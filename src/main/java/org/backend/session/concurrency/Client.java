package org.backend.session.concurrency;

public class Client {

    public static void main(String[] args) {
        System.out.println("1st Current thread -> " + Thread.currentThread().getName());

        //Assign a task to a thread
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloWorldPrinter);
        thread.start();

        Thread thread1 = new Thread(helloWorldPrinter);
        thread1.start();

        System.out.println("2nd Current thread -> " + Thread.currentThread().getName());


    }
}

/*
* Task : Print Hello from a new thread
*
* - create a task
*   -> Create a task class
*   -> Make this class implement Runnable interface
*   -> Implement the run() method
* - create a thread
*   -> Create a thread obj
* - Assign the task to the thread
*   -> Pass task object inside the constructor of thread class
* - start the thread
*   -> thread.start()
* */
