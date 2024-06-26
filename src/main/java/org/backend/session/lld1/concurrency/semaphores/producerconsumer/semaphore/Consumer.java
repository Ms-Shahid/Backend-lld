package org.backend.session.concurrency.semaphores.producerconsumer.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private String name;
    private int maxSize;
    private Semaphore consumerSemaphore;
    private Semaphore producerSemaphore;

    public Consumer(Queue<Object> store, String name, int maxSize,
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
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumer -> " + this.name + " consuming " + " consumed " + store.size());
            store.remove();
            producerSemaphore.release();
        }
    }
}
