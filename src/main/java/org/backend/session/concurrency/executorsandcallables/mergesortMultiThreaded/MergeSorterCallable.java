package org.backend.session.concurrency.executorsandcallables.mergesortMultiThreaded;

import java.util.List;
import java.util.concurrent.*;

public class MergeSorterCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(3, 2, 4, 1, 7, 6, 5, 8);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter mergeSorter = new Sorter(listToSort, executorService);

        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);
        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);
        executorService.shutdown();
    }
}
