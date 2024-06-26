package org.backend.session.concurrency.semaphores.producerconsumer.synchronize;

import java.util.Queue;

public class Producer implements Runnable{

    private Queue<Object> store;
    private String name;
    private int maxSize;

    public Producer(Queue<Object> store, String name, int maxSize){
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {

        while (true){
            synchronized (store){
                if( store.size() < maxSize ){
                    System.out.println("Producer -> " + this.name + " producing " + "Filled store slot -> " + store.size());
                    store.add(new Object());
                }
            }
        }

    }
}
