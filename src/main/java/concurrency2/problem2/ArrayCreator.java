package concurrency2.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayCreator implements Callable<List<Integer>> {

    Scanner scanner;
    List<Integer> numberList;
    ExecutorService executorService;
    public ArrayCreator(Scanner scanner, List<Integer> numberList, ExecutorService executorService){
        this.scanner = scanner;
        this.numberList = numberList;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {

        int n = scanner.nextInt();
        numberList = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            numberList.add(i);
        }

        return numberList;
    }


}
