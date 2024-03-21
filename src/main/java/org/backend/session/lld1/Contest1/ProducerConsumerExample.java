package org.backend.session.lld1.Contest1;

import java.util.LinkedList;


class SharedBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }


    public void produce(int item) throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == capacity) {
                wait();
            }
            buffer.add(item);
            notify();
        }
    }

    public int consume() throws InterruptedException {
        synchronized (this) {
            while (buffer.isEmpty()) {
                wait();
            }
            int item = buffer.remove();
            notify();
            return item;
        }
    }
}


public class ProducerConsumerExample {
    public void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(5);
// What does the following line of code do?
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedBuffer.produce(i);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
// What does the following line of code do?
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int item = sharedBuffer.consume();
                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

//This will ensure synchronization between producer & consumer