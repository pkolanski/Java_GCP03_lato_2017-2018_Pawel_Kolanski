package webcrawler.Models;

import webcrawler.Models.enums.Status;

import java.io.Serializable;

public class LoggedStudent extends Student implements Serializable{
    private long time;
    private Status status;

    public LoggedStudent(Student student,long time,String status) {
        this.setFirstName(student.getFirstName());
        this.setLastName(student.getLastName());
        this.setAge(student.getAge());
        this.setMark(student.getMark());
        if(status.equals("ADDED")){
            this.status=Status.ADDED;
        }
        else if(status.equals("REMOVED")){
            this.status=Status.REMOVED;
        }
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return getTime()+": "+getStatus().toString()+" "+
                "Student{" +
                "mark=" + mark +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}'+'\n';
    }
}
