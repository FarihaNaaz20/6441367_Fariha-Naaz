record Person(String name, int age) {}

import java.util.*;

public class Record {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 22),
            new Person("Bob", 30),
            new Person("Eve", 18)
        );

        people.stream()
              .filter(p -> p.age() >= 21)
              .forEach(System.out::println);
    }
}
