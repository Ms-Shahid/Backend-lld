package concurrency2.problem2;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6);
        Scanner scanner = new Scanner(System.in);
        ArrayCreator arrayCreator = new ArrayCreator(scanner, numberList, executorService);
        Future<List<Integer>> result = executorService.submit(arrayCreator);

        System.out.println(result.get());

        executorService.shutdown();

    }
}
