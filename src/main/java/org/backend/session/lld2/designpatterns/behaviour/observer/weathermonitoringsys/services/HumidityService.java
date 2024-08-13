package org.backend.session.lld2.designpatterns.observer.weathermonitoringsys.services;

import org.backend.session.lld2.designpatterns.observer.weathermonitoringsys.Observer;
import org.backend.session.lld2.designpatterns.observer.weathermonitoringsys.ObserverRegistry;
import org.backend.session.lld2.designpatterns.observer.weathermonitoringsys.notification.NotificationUtils;

public class HumidityService implements Observer {

    @Override
    public void notifyObserver(double weatherConditions) {
        //NotificationUtils.sendNotification(String.valueOf(weatherConditions));
        Runnable lamExp = () -> NotificationUtils.sendNotification(String.valueOf(weatherConditions));
    }
}
