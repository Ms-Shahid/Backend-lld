package concurrency3.problem1;

//get count & inc count
public class Counter {
    private int count;

    public Counter(int value){
        this.count = value;
    }

    public synchronized void incValue(int offset){
        count += offset;
    }

    public synchronized int getCount() {
        return count; 
    }

    public synchronized void decValue(int offset){
        count -= offset;
    }
}
