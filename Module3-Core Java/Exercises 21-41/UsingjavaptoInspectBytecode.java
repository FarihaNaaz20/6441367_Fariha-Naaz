public class Sample {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        int result = s.add(5, 3);
        System.out.println(result);
    }
}


Steps to follow:

1.Save the above code as Sample.java.
2.Compile: javac Sample.java
3.Inspect bytecode: javap -c Sample