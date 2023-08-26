import java.util.*;

public class Language {

    String name;
    LinkedList<Lesson> lessons = new LinkedList<Lesson>();
    String description;

    public String toString() {
        return name;
    }
}
