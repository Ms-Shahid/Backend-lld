package org.backend.session.lld2.designpatterns.observer.stocktrading;

public interface Observer {

    void notifyObserver(String stockName, double stockPrice);
}
