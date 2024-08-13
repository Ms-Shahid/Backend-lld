package org.backend.session.lld2.designpatterns.observer.weathermonitoringsys;

public interface ObserverRegistry {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(double value);
}
