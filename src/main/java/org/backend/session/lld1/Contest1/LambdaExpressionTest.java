package org.backend.session.lld1.Contest1;

import java.util.*;
import java.util.concurrent.*;

public class LambdaExpressionTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 10;
        Runnable r = () -> System.out.println(x);
        Thread thread = new Thread(r);
        thread.start();
        //produces -> 10 output

        compareStringObjectsInList();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
          Thread.sleep(2000);
          return 42;
        };

        Future<Integer> future = executorService.submit(task);
        Integer result = future.get();
        System.out.println(result);
        executorService.shutdown();

        //what does future.get() do ? -> It waits for the task to complete & returns the result.

    }


    public int predictOutput(int sum) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        numbers.forEach(n -> sum += n );
        //Variable used in lambda expression should be final or effectively fina
//        System.out.println(sum);
        return sum;
    }

    public static void compareStringObjectsInList(){
        List<String> list = new ArrayList<>(List.of("apple", "mango", "guava"));
        Comparator<String> comparator = ( s1, s2 ) -> s2.compareTo(s1);
        Collections.sort(list, comparator);
        System.out.println(list);
    }

    public void concurrentMapExample(){

        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);

        int valueA = concurrentMap.get("A");

        int valueB = concurrentMap.compute("B", (key, oddValue) -> (oddValue == null ) ? 1 : oddValue + 1);
        //Computes the values of B using Lambda function & returns it

        int valueC = concurrentMap.merge("C", 1, Integer :: sum );
        /*This implementation assumes that the ConcurrentMap cannot contain null values and get() returning null unambiguously means the key is absent.
        Implementations which support null values must override this default implementation.
        */

        concurrentMap.remove("A");

        boolean containsKeyB = concurrentMap.containsKey("B");
    }


    class Myclass {
        static int x = 10;

        public void main(String[] args) {

            Myclass obj1 = new Myclass();
            Myclass obj2 = new Myclass();
            obj1.x = 20;
            System.out.println(obj1.x + " " + obj2.x);
        }
        //Output => 20 20
        //The static variable x is shared among all instances of the class, when obj1.x = 20, it affects all instances.
        //so both obj1.x & obj2.x is changed.
    }
}
