package webcrawler.Models;

import java.io.IOException;

public interface Logger
{
    void log(String status, Student student) throws IOException;
}
