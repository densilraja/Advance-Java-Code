package Multithreading;

public class EvenOdd {
    int number = 1;
    int limit = 10;

    synchronized void printOdd() throws InterruptedException {

        while (number <= limit) {

            while (number % 2 == 0) {
                wait();
            }

            if (number <= limit) {
                System.out.println("Odd: " + number++);
                notify();
            }
        }
    }

    synchronized void printEven() throws InterruptedException {

        while (number <= limit) {

            while (number % 2 != 0) {
                wait();
            }

            if (number <= limit) {
                System.out.println("Even: " + number++);
                notify();
            }
        }
    }
}
