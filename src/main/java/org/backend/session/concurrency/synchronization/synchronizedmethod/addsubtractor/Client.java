package org.backend.session.concurrency.synchronization.synchronizedmethod.addsubtractor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(adder);
        executorService.submit(subtractor);

        executorService.shutdown();
        System.out.println(count.getValue());
    }
}
