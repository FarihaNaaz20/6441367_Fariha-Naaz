import java.util.*;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student ID and name (type -1 to stop):");
        while (true) {
            System.out.print("ID: ");
            int id = sc.nextInt();
            if (id == -1) break;
            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            students.put(id, name);
        }

        System.out.print("Enter ID to lookup: ");
        int lookupId = sc.nextInt();
        System.out.println("Student: " + students.getOrDefault(lookupId, "Not Found"));
    }
}