package org.backend.session.concurrency.executorsandcallables.executors;

import org.backend.session.concurrency.executorsandcallables.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrinterClientExecutors {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //here 10 threads have been created by executor service & it only uses 10 threads by reusing them

        for(int i = 1; i <= 100; i++){
            if( i == 5 || i == 55 || i == 95 ){
                System.out.println(" break point ");
            };
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.submit(numberPrinter);
        }
        executorService.shutdown();
    }
}
