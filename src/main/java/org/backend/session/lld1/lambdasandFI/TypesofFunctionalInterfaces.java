package org.backend.session.lld1.lambdasandFI;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class TypesofFunctionalInterfaces {

    public static void main(String[] args) {

//        BiPredicate biPredicate = new BiPredicate();
//        biPredicate.test("Shahid", 1);


        //way-2 : Anonymous class
        BiPredicate<String, Integer> biPredicate1 = new BiPredicate<String, Integer>() {
            @Override
            public boolean test(String s, Integer integer) {
                return false;
            }
        };

        //way-3
        BiPredicate<String, Integer> biPredicate2 = (str, val) -> str.length() > val;
        System.out.println(biPredicate2.test("Shahid", 15));

        //concatenate strings
        BinaryOperator<String> binaryOperator = ( str1, str2 ) -> {
            System.out.println("Lambda");
            return str1 + " " + str2;
        };

        System.out.println(binaryOperator.apply("Scaler", "Banglore"));

    }
}
