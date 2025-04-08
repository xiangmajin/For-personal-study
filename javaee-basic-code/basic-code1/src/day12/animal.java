package day12;

public interface animal {
    void eat();
    default void doSomethingElse() {
        System.out.println("Doing something else in new style.");
    }
}
