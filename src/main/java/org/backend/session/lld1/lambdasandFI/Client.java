package org.backend.session.lld1.lambdasandFI;

import java.util.*;

public class Client {

    public static class Car{
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
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 7, 9, 10);

        Collections.sort(numbers);
        System.out.println(numbers);

        Car car1 = new Car("A", 1000, 200);
        Car car2 = new Car("A", 50009, 700);
        Car car3 = new Car("A", 4000, 400);
        Car car4 = new Car("A", 3000, 500);
        Car car5 = new Car("A", 12000, 800);
        Car car6 = new Car("A", 14000, 900);

        List<Car> cars = Arrays.asList(car1, car2, car3, car4, car5, car6);

//        Comparator<Car> comparator = new Comparator<Car>() {
//            @Override
//            public int compare(Car c1, Car c2) {
//                return c1.speed - c2.speed;
//            }
//        };
//        Comparator<Car> comparator = ( c1, c2 ) -> c1.speed - c2.speed;

//        Collections.sort(cars, comparator);
        Collections.sort(cars, ( c1, c2 ) -> c1.speed - c2.speed);
        Collections.sort(cars, ( c1, c2 ) -> {
            if (c1.speed - c2.speed > c1.price - c2.price) {
                return c1.price - c2.price;
            }
            return c2.price - c1.price;
        });

        System.out.println(cars);
    }
}
