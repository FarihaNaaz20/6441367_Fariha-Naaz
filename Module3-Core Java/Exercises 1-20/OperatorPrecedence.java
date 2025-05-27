public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Result: " + result);
    }public class que8_OperatorPrecedence {
    public static void main(String[] args) {
        // Expression 1
        int result1 = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2 = " + result1); 

        // Expression 2
        int result2 = (10 + 5) * 2;
        System.out.println("Result of (10 + 5) * 2 = " + result2); 

        // Expression 3
        int result3 = 100 / 5 + 2 * 3;
 
        System.out.println("Result of 100 / 5 + 2 * 3 = " + result3); 

        // Expression 4
        int result4 = 100 / (5 + 5) * 3;
        System.out.println("Result of 100 / (5 + 5) * 3 = " + result4); 
    }
}
}
