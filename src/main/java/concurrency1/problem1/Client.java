package concurrency1.problem1;

import concurrency1.problem1.Adder;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your desired choice of numbers : " );
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        Adder adder = new Adder(num1, num2);
        Thread thread = new Thread(adder);
        thread.start();

    }
}
