package org.backend.session.lld2.designpatterns.observer.taskmanagementapp;

public interface TaskObserver {
    void notify(Long userId, Long taskId);
}
