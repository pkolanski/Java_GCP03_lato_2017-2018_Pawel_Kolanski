package webcrawler.Models;

import java.io.IOException;

@FunctionalInterface
public interface StudentListener {
    void handle(Student student) throws IOException;
}
