package org.backend.session.genetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {

    public static void main(String[] args) {

//        Pair p = new Pair();
//        p.first = "Scaler";
//        p.second = 100;
//
//        String city = (String) p.second;
//
//        System.out.println(city);

        Pair<String, Integer> pair = new Pair<>();
        pair.first = "India";
        pair.second = 140;

        String country = pair.first;
        System.out.println(country);

        //Raw types : This works & worked before generic -> hence its backward compatability
        HashMap hashMap = new HashMap();
        hashMap.put("Shahid", 90);
        hashMap.put(90, "Shahid");


        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Human> humans = new ArrayList<>();

        doSomething(animals);
        doSomething(dogs);

        doSomething1(animals);
//        doSomething1(dogs);
        doSomething1(humans);


//        List<Animal> animals1 = new ArrayList<Dog>();

            List<? extends Animal> animals1 = new ArrayList<Dog>();
            List< ? extends Animal> list = new ArrayList<>();
//            Animal dog = new Dog("Name", "breed");
//            list.add(dog);

    }

    public static void doSomething(List<? extends Animal> animals){
        System.out.println("Working... ");
    }

    public static void doSomething1(List<? super Animal> animals){
        System.out.println("Super working... ");
    }

    // ? extends means Animal + any child class of Animal
    // super Animal -> Animal + Parent class of Animal
}
