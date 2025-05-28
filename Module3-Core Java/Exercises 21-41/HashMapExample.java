import java.util.HashMap;
import java.util.Scanner;
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Enter student ID (or type 'exit' to finish): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            int id = Integer.parseInt(input);
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }
        System.out.print("Enter an ID to retrieve the student name: ");
        int searchId = scanner.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("ID not found.");
        }

        scanner.close();
    }
}
