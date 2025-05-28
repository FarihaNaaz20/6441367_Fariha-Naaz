public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 20 / 4 + 2 * 3;
        int result4 = 10 + 6 / 2 - 3;
        System.out.println("Result of 10 + 5 * 2 = " + result1);
        System.out.println("Result of (10 + 5) * 2 = " + result2);
        System.out.println("Result of 20 / 4 + 2 * 3 = " + result3);
        System.out.println("Result of 10 + 6 / 2 - 3 = " + result4);
        System.out.println("\nExplanation:");
        System.out.println("1) Multiplication and division have higher precedence than addition and subtraction.");
        System.out.println("2) Operators with the same precedence are evaluated left to right.");
        System.out.println("3) Parentheses alter the default precedence, forcing expressions inside to be evaluated first.");
    }
}
