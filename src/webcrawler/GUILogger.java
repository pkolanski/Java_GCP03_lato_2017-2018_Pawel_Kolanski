package webcrawler;

public class GUILogger implements Logger {
    @Override
    public void log(String status, Student student) {

        StudentProperty sp = new StudentProperty(student.getMark(), student.getFirstName(), student.getLastName(), student.getAge());

        if("ADDED".equals(status)) {

            ObserveList.addToObList(sp, status);
        } else if ("REMOVED".equals(status)){
            ObserveList.removeFromObList(sp, status);
        }

    }
}
