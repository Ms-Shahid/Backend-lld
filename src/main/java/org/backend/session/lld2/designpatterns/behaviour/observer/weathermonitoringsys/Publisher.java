package org.backend.session.lld2.designpatterns.observer.weathermonitoringsys;

import java.util.ArrayList;
import java.util.List;

public interface Publisher extends ObserverRegistry{
    List<Observer> observers = new ArrayList<>();

    default void addObserver(Observer observer){
        observers.add(observer);
    }

    default void removeObserver(Observer observer){
        observers.remove(observer);
    }

   default void notifyObservers(double value){
        observers.forEach( observer -> observer.notifyObserver(value));
    }
}
