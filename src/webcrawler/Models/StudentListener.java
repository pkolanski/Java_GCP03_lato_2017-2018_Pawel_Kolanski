package webcrawler.Models;

import webcrawler.Models.Student;

@FunctionalInterface
public interface StudentListener {
    void handle(Student student);
}
