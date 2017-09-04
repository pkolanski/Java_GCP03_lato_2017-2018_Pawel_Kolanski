package webcrawler.Models;

@FunctionalInterface
public interface IterationListener {
    void handle(int iteration);
}
