package org.backend.session.concurrency;

public class HelloWorldPrinter implements Runnable{

    @Override
    public void run(){
        //Write the code that you want to execute from a sperate thread -> Task code
        System.out.println(" Task created & Thread assigned -> " + Thread.currentThread().getName());
    }
}
