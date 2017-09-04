package webcrawler;

import webcrawler.enums.OrderMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Monitor {
    public List<String> fileList;
    private int threadCount;
    public MyThread[] threadTab=null;
    public boolean runFlag=false;
    public Monitor( List<String> listOfFiles, int n ) throws MonitorException
    {
        fileList = listOfFiles;
        if (n < fileList.size() )
            throw ( new MonitorException() );
        else
            threadCount = listOfFiles.size();
    }

    List<StudentEvent> stAddedList = new ArrayList<>();
    public void studentAddedEvent( StudentEvent st )
    {
        stAddedList.add( st );
    }

    List<StudentEvent> stDeletedList = new ArrayList<>();
    public void studentRemovedEvent( StudentEvent st )
    {
        stDeletedList.add( st );
    }

    public void run() throws InterruptedException, IOException, CrawlerException
    {
        if ( threadTab == null )
        {
            runFlag = true;
            threadTab = new MyThread[threadCount];
            for ( int i = 0; i < threadCount; i++ )
            {
                threadTab[i] = new MyThread( fileList.get( i ), OrderMode.MARK );
                threadTab[i].setName( "Crawler number #" + i );
                threadTab[i].start();
            }
        }

    }

    public synchronized void cancel() throws InterruptedException
    {
        if ( threadTab != null )
        {

            runFlag = false;
            for ( int i = 0; i < threadCount; i++ )
            {
                threadTab[i].crawler.postCancel();
                threadTab[i].join();
            }
        }
    }

    class MyThread extends Thread
    {
        private Crawler crawler;

        public MyThread( String address, OrderMode md )
        {
            crawler=new Crawler();
            crawler.setAddress(address);
            crawler.addIterationStartedListener( ( it ) ->
                    System.out.println( "\n" + getName() + " Iteracja: " + it ) );

            crawler.addStudentAddedListener( ( student ) ->
            {
                for ( StudentEvent el : stAddedList )
                    el.handled( student );
            } );

            crawler.addStudentRemovedListener( ( student ) ->
            {
                for ( StudentEvent el : stDeletedList )
                    el.handled( student );
            } );
        }

        @Override
        public void run()
        {
            while ( runFlag )
            {
                try
                {
                    crawler.run();
                }
                catch ( CrawlerException e )
                {
                    e.printStackTrace();
                }
                catch ( InterruptedException e )
                {
                    System.out.println( "Interrupted." );
                }
                catch ( IOException e ) {}
            }
        }
    }
}
