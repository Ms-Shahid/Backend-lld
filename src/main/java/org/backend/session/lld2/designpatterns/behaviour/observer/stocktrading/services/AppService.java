package org.backend.session.lld2.designpatterns.observer.stocktrading.services;

import org.backend.session.lld2.designpatterns.observer.stocktrading.Observer;
import org.backend.session.lld2.designpatterns.observer.stocktrading.ObserverRegistry;
import org.backend.session.lld2.designpatterns.observer.stocktrading.utils.Notification;

public class AppService implements Observer {


    @Override
    public void notifyObserver(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        Notification.sendPush(subject, message);
    }
}
