import java.util.List;
import java.util.stream.Collectors;
record Person(String name, int age) {}
public class RecordExample {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 20);
        Person p3 = new Person("Charlie", 25);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        List<Person> people = List.of(p1, p2, p3);
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 21)
                                    .collect(Collectors.toList());
        adults.forEach(System.out::println);
    }
}
