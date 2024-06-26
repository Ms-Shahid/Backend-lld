package org.backend.session.concurrency.semaphores.producerconsumer.executorservice;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductStore {

    public static void main(String[] args) {

//        Queue<Object> store = new ArrayDeque<>();
        Queue<Objects> store = new ConcurrentLinkedDeque<>();
        int maxSize = 6;
        Producer p1 = new Producer(store, "P1", maxSize);
        Producer p2 = new Producer(store, "P2", maxSize);
        Producer p3 = new Producer(store, "P3", maxSize);
        Producer p4 = new Producer(store, "P4", maxSize);
        Producer p5 = new Producer(store, "P5", maxSize);

        Consumer c1 = new Consumer(store, "C1", maxSize);
        Consumer c2 = new Consumer(store, "C2", maxSize);
        Consumer c3 = new Consumer(store, "C3", maxSize);
        Consumer c4 = new Consumer(store, "C4", maxSize);
        Consumer c5 = new Consumer(store, "C5", maxSize);
        Consumer c6 = new Consumer(store, "C6", maxSize);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(p3);
        executorService.submit(p4);
        executorService.submit(p5);
        executorService.submit(c1);
        executorService.submit(c2);
        executorService.submit(c3);
        executorService.submit(c4);
    }
}
