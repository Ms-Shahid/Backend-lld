package org.backend.session.concurrency.IntroductiontoProcessesandThreads.designThreads;

//way-1 : Extending Thread class
class MyThread extends Thread{

    public void run(){
        for(int i = 1; i <= 10000; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

//way-2 : Implementing Runnable Interface
class Task implements Runnable{

    @Override
    public void run() {
        for(double i = 10.4; i <= 100.4; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
public class DesignThreadInWays {

    public static void main(String[] args) {

        //Since MyThread extends Thread class, we can call start() method directly, as it is a member of Thread class
        MyThread thread = new MyThread();
        thread.start();

        //Task implementes Runnable interface & hence we need to create a Thread obj & assign task to thread & start the thread
        Task task = new Task();
        Thread thread1 = new Thread(task);
        thread1.start();
        

    }
}
