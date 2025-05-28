import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        while (guess != target) {
            System.out.print("Guess the number (1-100): ");
            guess = scanner.nextInt();
            if (guess < target) {
                System.out.println("Too low. Try again.");
            } else if (guess > target) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Correct! You guessed the number.");
            }
        }

        scanner.close();
    }
}
