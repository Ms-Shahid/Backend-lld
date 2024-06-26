package org.backend.session.concurrency.executorsandcallables.mergesortMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    List<Integer> listToSort;
    ExecutorService executorService;
    public Sorter(List<Integer> listToSort, ExecutorService executorService){
        this.listToSort = listToSort;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {

        //merge sort
        int size = listToSort.size();

        if( size <= 1 ) return listToSort;

        List<Integer> leftHalf = new ArrayList<>();
        List<Integer> rightHalf = new ArrayList<>();

        for(int i = 0; i < size/2; i++){
            leftHalf.add( listToSort.get(i) );
        }

        for(int i = size/2; i < size; i++){
            rightHalf.add( listToSort.get(i) );
        }

        //assign it to tasks: leftHalf & rightHalf in a operate thread

        Sorter leftMergeSorter = new Sorter(leftHalf, executorService);
        Sorter rightMergeSorter = new Sorter(rightHalf, executorService);
//        ExecutorService executors = Executors.newCachedThreadPool(); // If we are not sure about the no. of thread-pool size
//        List<Integer> leftSortedList = executors.submit(leftMergeSorter);
//        List<Integer> rightSortedList = executors.submit(rightMergeSorter);

        /* The problem here is line 42 & 43 are running in parallel
        * And since 42 & 43 both are expecting sorted line of integers in this case,
        * We aren't sure about the time it takes to sort, line 42 might be taking little more time
        * until then line 43 will not be executed, therefore its not multithreading or parallel anymore.
        * The error is saying that the left side part can't assure about the time its going to take, it can take 5 mins
        * 10 mins not sure */

        /* Executors tells that it can't assure the time, but we can expect a future of list of sorted number
        * Hence we can make use of Futures in Java (Future mein milega, but assurance is given)
        * Futures gives an assurance that in future we can get it */

        Future<List<Integer>> leftSortedListFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedListFuture = executorService.submit(rightMergeSorter);

        //merge only when both the leftSortedListFuture & rightSortedListFuture are done with there tasks, these are blocking calls
        List<Integer> leftSortedList = leftSortedListFuture.get();
        List<Integer> rightSortedList = rightSortedListFuture.get();

        int p1 = 0, p2 =0;
        List<Integer> sortedList = new ArrayList<>();

        while (p1 < leftSortedList.size() && p2 < rightSortedList.size() ){
            if( leftSortedList.get(p1) < rightSortedList.get(p2) ){
                sortedList.add( leftSortedList.get(p1) );
                p1++;
            }else{
                sortedList.add( rightSortedList.get(p2) );
                p2++;
            }

        }

        while( p1 < leftSortedList.size() ){
            sortedList.add( leftSortedList.get(p1) );
            p1++;
        }
        while( p2 < rightSortedList.size() ){
            sortedList.add( rightSortedList.get(p2));
            p2++;
        }
        return sortedList;
    }
}

/*
* Steps
* -> Create a Sorter task
* -> Make this implement Callable interface
* -> implement call method with MergeSort logic
* */
