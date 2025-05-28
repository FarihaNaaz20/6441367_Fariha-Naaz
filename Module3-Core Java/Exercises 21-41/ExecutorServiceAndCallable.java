import java.util.concurrent.*;
import java.util.*;
public class ExecutorCallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> "Task 1 result");
        tasks.add(() -> "Task 2 result");
        tasks.add(() -> "Task 3 result");
        List<Future<String>> results = executor.invokeAll(tasks);
        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        executor.shutdown();
    }
}
