package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 3;

    public synchronized void produce(int value) throws InterruptedException{
        while (queue.size() == LIMIT) { 
            wait();
        }
        queue.add(value);
        System.out.println("Value produced : " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException{
        while (queue.isEmpty()) { 
            wait();
        }
        int val = queue.poll();
        System.out.println("Value consumed : " + val);
        notify();
    }
}
