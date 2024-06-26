package org.backend.session.concurrency.semaphores.producerconsumer.synchronize;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Object> store;
    private String name;
    private int maxSize;

    public Consumer(Queue<Object> store, String name, int maxSize){
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {

        while (true){
            synchronized (store){
                if(!store.isEmpty()){
                    System.out.println("Consumer -> " + this.name + " consuming " + " consumed " + store.size());
                    store.remove();
                }
            }
        }
    }
}
