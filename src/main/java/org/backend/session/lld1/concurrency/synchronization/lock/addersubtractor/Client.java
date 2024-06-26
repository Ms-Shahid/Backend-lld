package org.backend.session.concurrency.synchronization.lock.addersubtractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Lock lock = new ReentrantLock(); //MuTEX
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        Thread thread1 = new Thread(adder);
        Thread thread2 = new Thread(subtractor);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        //join waits for thread1 & thread2 to complete & then proceed for below lines

        System.out.println("output -> " + count.value);
    }
}
