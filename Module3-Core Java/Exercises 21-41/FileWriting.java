import java.io.*;
import java.util.Scanner;

public class FileWriteExample {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write to file: ");
        String text = sc.nextLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(text);
        writer.close();

        System.out.println("Data written to output.txt successfully.");
    }
}