class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    public static void main(String[] args) {
        int age = 15;
        try {
            if (age < 18)
                throw new InvalidAgeException("Not eligible to vote");
            else
                System.out.println("Eligible to vote");
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}