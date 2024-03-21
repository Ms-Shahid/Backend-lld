package org.backend.session.lld1.collection;

import org.backend.session.lld1.lambdasandFI.Client;

import java.util.*;

class Car implements Comparable<Car>{
    String name;
    public int price;
    int speed;

    public Car(String name, int price, int speed){
        this.name = name;
        this.price = price;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + this.name + '\'' +
                ", price=" + this.price +
                ", speed=" + this.speed +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        //if the names are not equal, then compare names
        if( !this.name.equals(car.name) ){
            return this.name.compareTo(car.name);
        }else{
            return this.price - car.price;
        }
    }
}
public class CollectionsDS {


    public static void main(String[] args) {


        Set<String> set = new HashSet<>();
        Set<String> lhs = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        set.add("India");
        set.add("Srilanka");
        set.add("USA");
        set.add("Dubai");

        System.out.println(set);

        lhs.add("India");
        lhs.add("Srilanka");
        lhs.add("USA");
        lhs.add("Dubai");

        System.out.println(lhs);


        Client.Car car1 = new Client.Car("A", 1000, 200);
        Client.Car car2 = new Client.Car("A", 50009, 700);
        Client.Car car3 = new Client.Car("A", 4000, 400);
        Client.Car car4 = new Client.Car("A", 3000, 500);
        Client.Car car5 = new Client.Car("A", 12000, 800);
        Client.Car car6 = new Client.Car("A", 14000, 900);

        Set<Car> cars = new TreeSet<Car>();


    }
}
