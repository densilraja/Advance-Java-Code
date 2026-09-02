package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private int a = 0;   // shared resource

    public void shared() {
        synchronized (this) {
            System.out.println("a -> " + ++a);
        }
    }

    

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();

        Thread t = new Thread(() -> {
            System.out.println("Task 1 Started");
            for (int i = 1; i <= 10; i++) {
                System.out.println("first");
                m.shared();   // accessing shared resource
                // try {
                //     Thread.sleep(500);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
        });

        Thread t1 = new Thread(() -> {
            System.out.println("Task 2 Started");
            for (int i = 1; i <= 10; i++) {
                System.out.println("second");
                m.shared();   // also accessing shared resource
                //     try {
                //         Thread.sleep(500);
                //     } catch (InterruptedException e) {
                //         e.printStackTrace();
                //     }
            }
        });

        t.start();
        t.join();

        t1.start();
        t1.join();
        System.out.println("Main Thread Finished");
        System.out.println("--------------------------");
        execute();

        EvenOdd eo = new EvenOdd();

        Thread odd = new Thread(() -> {
            try {
                eo.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread even = new Thread(() -> {
            try {
                eo.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        odd.start();
        even.start();
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println();

        ProducerConsumer pc = new ProducerConsumer();
        
        Thread produce = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    pc.produce(i);
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });

        Thread consume = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    pc.consume();
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });

        produce.start();
        consume.start();


    }

    public static void execute() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        System.out.println("Executing tasks using ExecutorService");

        for (int i = 0; i < 3; i++) {
            service.execute(() -> System.out.println("Task executed by " + Thread.currentThread().getName()));
            service.execute(() -> System.out.println("Task executed by " + Thread.currentThread().getName()));
            service.execute(() -> System.out.println("Task executed by " + Thread.currentThread().getName()));
        }
        service.shutdown();
        
        System.out.println("ExecutorService Finished");
    }
}
