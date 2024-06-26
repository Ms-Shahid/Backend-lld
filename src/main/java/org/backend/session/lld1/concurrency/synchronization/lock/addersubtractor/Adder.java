package org.backend.session.concurrency.synchronization.lock.addersubtractor;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    Count count;
    Lock lock;
    public Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 100000; i++){
            //only the count object is the critical section. Hence lock on that data only
            lock.lock();
            count.value += i;
            lock.unlock();
        }
    }
}
