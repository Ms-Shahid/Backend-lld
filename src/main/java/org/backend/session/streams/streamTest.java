package org.backend.session.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamTest {

    static class Car{
        String name;
        int price;
        int speed;

        Car(String name, int price, int speed){
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

        List<Integer> numbers = Arrays.asList(10, 3, 4, 6, 7, 8 , 9);
        Stream<Integer> stream = numbers.stream();

        //ways -2
        Integer[] arr = {1, 3, 4, 5, 6};
        Stream<Integer> stream1 = Stream.of(arr);

        //Builder
        Stream.Builder<Integer> stream2 = Stream.builder();


        List<Integer> evenNumber = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++){
            if( numbers.get(i) % 2 == 0 ) evenNumber.add( numbers.get(i) );

        }
//        System.out.println(evenNumber);

        System.out.println(numbers.stream().filter( num  -> num % 2 == 0 ).toList());



        Car car1 = new Car("A", 1000, 200);
        Car car2 = new Car("A", 50009, 700);
        Car car3 = new Car("A", 4000, 400);
        Car car4 = new Car("A", 3000, 500);
        Car car5 = new Car("A", 12000, 800);
        Car car6 = new Car("A", 14000, 900);

        List<Car> cars = Arrays.asList(car1, car2, car3, car4, car5, car6);

        List<Car> expensiveCars = cars.stream().filter( c1 -> c1.price > 1000).toList();

        //list of cars
        List<Integer> carsList = cars.stream().map(car -> car.price).toList();

    }
}
