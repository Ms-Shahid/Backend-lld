package org.backend.session.lld1.customcomparision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUsingSumDigits {


    public static int getSumOfDigits(Integer num) {

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(22);
        numbers.add(34);
        numbers.add(56);
        numbers.add(90);
        numbers.add(87);
        numbers.add(46);

            //first way
//        Collections.sort(numbers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return getSumOfDigits(o1) - getSumOfDigits(o2);
//            }
//        });

        //second way
//        Collections.sort(numbers, (a, b) -> getSumOfDigits(a) - getSumOfDigits(b) );

        //3rd way
        Collections.sort(numbers, Comparator.comparingInt(SortUsingSumDigits::getSumOfDigits));

        System.out.println(numbers);
    }
}
