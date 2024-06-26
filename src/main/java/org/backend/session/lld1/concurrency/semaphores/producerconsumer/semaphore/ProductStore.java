package org.backend.session.concurrency.semaphores.producerconsumer.semaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProductStore {

    public static void main(String[] args) {

        Queue<Object> store = new ArrayDeque<>();
        int maxSize = 6;
        Semaphore producerSemaphore = new Semaphore(maxSize);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer p1 = new Producer(store, "P1", maxSize, producerSemaphore, consumerSemaphore);
        Producer p2 = new Producer(store, "P2", maxSize, producerSemaphore, consumerSemaphore);
        Producer p3 = new Producer(store, "P3", maxSize, producerSemaphore, consumerSemaphore);

        Consumer c1 = new Consumer(store, "C1", maxSize, producerSemaphore, consumerSemaphore);
        Consumer c2 = new Consumer(store, "C2", maxSize, producerSemaphore, consumerSemaphore);
        Consumer c3 = new Consumer(store, "C3", maxSize, producerSemaphore, consumerSemaphore);
        Consumer c4 = new Consumer(store, "C4", maxSize, producerSemaphore, consumerSemaphore);
        Consumer c5 = new Consumer(store, "C5", maxSize, producerSemaphore, consumerSemaphore);
        Consumer c6 = new Consumer(store, "C6", maxSize, producerSemaphore, consumerSemaphore);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        Thread t6 = new Thread(c1);
        t6.start();
        Thread t7 = new Thread(c2);
        t7.start();
        Thread t8 = new Thread(c3);
        t8.start();
        Thread t9 = new Thread(c4);
        t9.start();
        Thread t10 = new Thread(c5);
        t10.start();
        Thread t11 = new Thread(c6);
        t11.start();
    }
}
