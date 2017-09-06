package webcrawler.Models;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressedLogger implements Logger,Closeable {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_ms");
    @Override
    public void close() throws IOException {

    }

    @Override
    public void log(String status, Student student) {
        Date date=new Date();
        String dirPath="D:\\Projekty\\Projekty Java\\Java_GCP03_lato_2017-2018_Pawel_Kolanski\\CompressedTextLogs\\";
        String fileName= dirPath +dateFormat.format(date).toString();
        TextLogger textLogger=new TextLogger(fileName);
        textLogger.log(status,student);
        File file=new File("CompressedLog.zip");
        FileOutputStream fileOutputStream= null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ZipOutputStream zipOutputStream=new ZipOutputStream(fileOutputStream);
        File dir=new File(dirPath);
        FileSystem fileSystem=new FileSystem(dir);
        Iterator allFiles=fileSystem.getFiles(true).iterator();
        while(allFiles.hasNext()){
            File srcFile = (File)allFiles.next();
            String filePath=srcFile.getAbsolutePath();
            ZipEntry zipEntry = new ZipEntry(filePath);
            zipEntry.setTime(srcFile.lastModified());
            try {
                FileInputStream fileInputStream = new FileInputStream(srcFile);
                zipOutputStream.putNextEntry(zipEntry);
                IOHandler.pipe(fileInputStream, zipOutputStream);
                zipOutputStream.closeEntry();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
