public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[100_000];
        for (int i = 0; i < 100_000; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread " + Thread.currentThread().getName());
            });
        }
        for (Thread t : threads) {
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken with virtual threads: " + (end - start) + " ms");
    }
}
