package org.backend.session.lld2.designpatterns.observer.stocktrading;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher implements ObserverRegistry{

    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String stockName, double currentPrice){
        observers.forEach( m -> m.notifyObserver(stockName, currentPrice));
    }
}
