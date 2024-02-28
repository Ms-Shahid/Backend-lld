package org.backend.session.concurrency.executorsandcallables;

public class NumberPrinterClient {

    public static void main(String[] args) {
        NumberPrinter numberPrinter;
        Thread thread;

        for(int i = 1; i <= 100; i++){
            numberPrinter = new NumberPrinter(i);
            thread = new Thread(numberPrinter);
            thread.start();
        }
    }
}
