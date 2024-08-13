package org.backend.session.lld2.designpatterns.observer.taskmanagementapp;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskPublisher implements TaskObserverRegistry{

    List<TaskObserver> observers = new ArrayList<>();
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(Long taskId, Long userId){
        observers.forEach( subs -> subs.notify(userId, taskId));
    }
}

