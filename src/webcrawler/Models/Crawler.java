package webcrawler.Models;

import webcrawler.Models.comparators.AgeComparator;
import webcrawler.Models.comparators.FirstNameComparator;
import webcrawler.Models.comparators.LastNameComparator;
import webcrawler.Models.comparators.MarkComparator;
import webcrawler.Models.enums.ExtremumMode;
import webcrawler.Models.enums.OrderMode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crawler
{

    private String address;
    private List<StudentListener> studentAddedListeners = new ArrayList<>();
    private List<StudentListener> studentRemovedListeners = new ArrayList<>();
    private List<IterationListener> iterationStartedListeners = new ArrayList<>();
    private List<IterationListener> iterationFinishedListeners = new ArrayList<>();
    private List<Student> studentsList;
    private List<Student> newStudentList;
    public Crawler()
    {
        address=null;
        studentsList=new ArrayList<>();
    }

    //EVENTY
    public void addIterationStartedListener(IterationListener iterationListener){
        iterationStartedListeners.add(iterationListener);
    }

    public void removeIterationStartedListener(IterationListener iterationListener){
        iterationStartedListeners.remove(iterationListener);
    }
    public void addIterationFinishedListener(IterationListener iterationListener){
        iterationFinishedListeners.add(iterationListener);
    }

    public void removeIterationFinishedListener(IterationListener iterationListener){
        iterationFinishedListeners.remove(iterationFinishedListeners);
    }

    public void addStudentAddedListener(StudentListener studentListener){
        studentAddedListeners.add(studentListener);
    }

    public void addStudentRemovedListener(StudentListener studentListener){
        studentRemovedListeners.add(studentListener);
    }

    public void removeStudentAddedListener(StudentListener studentListener){
        studentAddedListeners.remove(studentListener);
    }
    public void removeStudentRemovedListener(StudentListener studentListener){
        studentRemovedListeners.remove(studentListener);
    }
    //ADDRESS
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return this.address;
    }
    //EXTRACTS
    public List<Student> extractStudents(OrderMode mode)
    {
        List<Student> temp = studentsList;
        switch (mode)
        {
            case MARK: Collections.sort(temp,new MarkComparator()); break;
            case AGE: Collections.sort(temp,new AgeComparator()); break;
            case FIRST_NAME: Collections.sort(temp,new FirstNameComparator()); break;
            case LAST_NAME: Collections.sort(temp,new LastNameComparator()); break;
        }
        return temp;
    }
    public double extractMark(ExtremumMode mode)
    {
        switch(mode)
        {
            case MAX: return Collections.max(studentsList,new MarkComparator()).getMark();
            case MIN: return Collections.min(studentsList,new MarkComparator()).getMark();
        }
        return 0;
    }
    public int extractAge(ExtremumMode mode)
    {
        switch(mode)
        {
            case MAX: return Collections.max(studentsList,new AgeComparator()).getAge();
            case MIN: return Collections.min(studentsList,new AgeComparator()).getAge();
        }
        return 0;
    }
    public void run() throws CrawlerException, IOException, InterruptedException {
        if(address==null)throw new CrawlerException();
        int iteration=0;
        boolean flag1=false;
        boolean flag2=false;
        List<Student> studentsToRemove = new ArrayList<Student>();
        while(true)
        {
            iteration++;
            for(IterationListener el:iterationStartedListeners){el.handle(iteration);}
            this.newStudentList= StudentsParser.parse(new File(address));

            for(Student student:studentsList){
                if(studentsList.contains(student)&&!newStudentList.contains(student))
                {
                    for (StudentListener el : studentRemovedListeners) {
                        el.handle(student);
                        studentsToRemove.add(student);
                    }
                    flag1=true;
                }
            }
            for(Student student : newStudentList) {
                if (!studentsList.contains(student)) {
                    studentsList.add(student);
                    for (StudentListener el : studentAddedListeners) {
                        el.handle(student);
                    }
                    flag2=true;
                }
            }
            for(Student student : studentsToRemove){
                this.studentsList.remove(student);
            }
            studentsToRemove.clear();
            newStudentList.clear();
            List<Student> students = this.extractStudents(OrderMode.MARK);
            System.out.println("Ordered by mark:");
            for (Student student : students) {
                student.show();
            }
            System.out.println("Age <" + this.extractAge(ExtremumMode.MIN) + ", " + this.extractAge(ExtremumMode.MAX) + ">");
            System.out.println("Mark <" + this.extractMark(ExtremumMode.MIN) + ", " + this.extractMark(ExtremumMode.MAX) + ">");
            if(!flag1 && !flag2)
            {
                System.out.println("List was not modified.");
            }
            for(IterationListener el:iterationFinishedListeners){el.handle(iteration);}
            flag1=flag2=false;
            Thread.sleep(10000);
        }
    }
}
