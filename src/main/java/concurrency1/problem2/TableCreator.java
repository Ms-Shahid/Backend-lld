package concurrency1.problem2;

public class TableCreator implements Runnable{
    int number;
    public TableCreator(int number){
        this.number = number;
    }


    @Override
    public void run() {
        for( int i = 1; i <= 10; i++)
            System.out.println(number + " times " + i + " is " + number * i);
    }
}
