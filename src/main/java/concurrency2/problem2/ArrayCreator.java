package concurrency2.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {



    @Override
    public List<Integer> call() throws Exception {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numberList = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            numberList.add(i);
        }

        return null;
    }


}
