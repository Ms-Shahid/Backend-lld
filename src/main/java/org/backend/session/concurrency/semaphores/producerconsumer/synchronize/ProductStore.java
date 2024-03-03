package org.backend.session.concurrency.semaphores.producerconsumer.synchronize;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProductStore {

    public static void main(String[] args) {

//        Queue<Object> store = new ArrayDeque<>();
        Queue<Object> store = new ConcurrentLinkedQueue<>();
        int maxSize = 6;
        Producer p1 = new Producer(store, "P1", maxSize);
        Producer p2 = new Producer(store, "P2", maxSize);
        Producer p3 = new Producer(store, "P3", maxSize);
//        Producer p4 = new Producer(store, "P4", maxSize);
//        Producer p5 = new Producer(store, "P5", maxSize);

        Consumer c1 = new Consumer(store, "C1", maxSize);
        Consumer c2 = new Consumer(store, "C2", maxSize);
        Consumer c3 = new Consumer(store, "C3", maxSize);
        Consumer c4 = new Consumer(store, "C4", maxSize);
        Consumer c5 = new Consumer(store, "C5", maxSize);
        Consumer c6 = new Consumer(store, "C6", maxSize);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();
//        Thread t4 = new Thread(p4);
//        Thread t5 = new Thread(p5);

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
