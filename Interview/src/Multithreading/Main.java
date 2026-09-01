package Multithreading;

public class Main {

    private int a = 0;   // shared resource

    public void shared() {
        synchronized (this) {
            System.out.println("a -> " + ++a);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        Thread t = new Thread(() -> {
            System.out.println("Task 1 Started");
            for (int i = 1; i <= 10; i++) {
                System.out.println("first");
                m.shared();   // accessing shared resource
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t1 = new Thread(() -> {
            System.out.println("Task 2 Started");
            for (int i = 1; i <= 10; i++) {
                System.out.println("second");
                m.shared();   // also accessing shared resource
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        t1.start();
    }
}
