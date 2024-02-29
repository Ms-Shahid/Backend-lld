package org.backend.session.concurrency.synchronization.synchronizedmethod.addsubtractor;

public class Count {

    private int value = 0;

    public synchronized void updateValue(int i){
        value += i;
    }

    public int getValue(){
        return value;
    }
}
