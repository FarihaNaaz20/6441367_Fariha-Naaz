import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Enter a student name (or type 'exit' to finish): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            names.add(input);
        }
        System.out.println("Student names:");
        for (String name : names) {
            System.out.println(name);
        }
        scanner.close();
    }
}
