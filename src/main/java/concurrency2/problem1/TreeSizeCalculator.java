package concurrency2.problem1;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    Node root;
    ExecutorService executorService;


    public TreeSizeCalculator(Node root, ExecutorService executorService) {
        this.executorService = executorService;
        this.root = root;
    }


    @Override
    public Integer call() throws Exception {

        if( root == null ) return 0;

        TreeSizeCalculator leftTreeSize = new TreeSizeCalculator(root.left, executorService);
        TreeSizeCalculator rightTreeSize = new TreeSizeCalculator(root.right, executorService);

        //submit to create threads
        Future<Integer> leftFutureTreeSize = executorService.submit(leftTreeSize);
        Future<Integer> rightFutureTreeSize = executorService.submit(rightTreeSize);

        return leftFutureTreeSize.get() + rightFutureTreeSize.get() + 1;
    }
}
