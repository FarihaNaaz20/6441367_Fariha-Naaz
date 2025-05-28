public class Sample {
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
}
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Sample");
        Object obj = cls.getDeclaredConstructor().newInstance();
        java.lang.reflect.Method[] methods = cls.getDeclaredMethods();
        for (java.lang.reflect.Method method : methods) {
            System.out.println("Method: " + method.getName());
            Class<?>[] params = method.getParameterTypes();
            System.out.print("Parameters: ");
            for (Class<?> param : params) {
                System.out.print(param.getName() + " ");
            }
            System.out.println();
        }
        java.lang.reflect.Method greetMethod = cls.getDeclaredMethod("greet", String.class);
        greetMethod.invoke(obj, "World");
    }
}
