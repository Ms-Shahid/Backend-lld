package org.backend.session.concurrency.semaphores.producerconsumer.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private Queue<Object> store;
    private String name;
    private int maxSize;
    private Semaphore consumerSemaphore;
    private Semaphore producerSemaphore;

    public Producer(Queue<Object> store, String name, int maxSize,
                    Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }

    @Override
    public void run() {

        while (true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Producer -> " + this.name + " producing " + "Filled store slot -> " + store.size());
            store.add(new Object());
            consumerSemaphore.release();

        }

    }
}
