package org.backend.session.lld2.designpatterns.observer.taskmanagementapp;

public interface TaskObserverRegistry {
    void addObserver(TaskObserver observer);

    void removeObserver(TaskObserver observer);

    void notifyObservers(Long taskId, Long userId);
}
