package org.backend.session.lld2.designpatterns.observer.taskmanagementapp;

public class TaskManager extends TaskPublisher{

    public void assignTask(Long taskId, Long userId) {
        notifyObservers(taskId, userId);

    }
}
