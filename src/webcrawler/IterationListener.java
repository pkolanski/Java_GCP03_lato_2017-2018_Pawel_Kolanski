package webcrawler;

@FunctionalInterface
public interface IterationListener {
    void handle(int iteration);
}
