package org.backend.session.concurrency.semaphores.producerconsumer.executorservice;

import java.util.Objects;
import java.util.Queue;

public class Producer implements Runnable{

    private Queue<Objects> store;
    private String name;
    private int maxSize;

    public Producer(Queue<Objects> store, String name, int maxSize){
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {

        while (true){
            if( store.size() < maxSize ){
                System.out.println("Producer -> " + this.name + " producing " + "Filled store slot -> " + store.size());
                store.add((Objects) new Object());
            }
        }

    }
}
