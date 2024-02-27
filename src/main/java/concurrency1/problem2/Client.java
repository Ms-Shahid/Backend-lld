package concurrency1.problem2;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int number = scanner.nextInt();


        for( int i = 1; i <= number; i++){
            TableCreator tableCreator = new TableCreator(i) ;
            Thread thread = new Thread(tableCreator);
            thread.start();
        }

    }
}
