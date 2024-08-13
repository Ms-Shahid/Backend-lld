package org.backend.session.lld2.designpatterns.observer.taskmanagementapp.services;

import org.backend.session.lld2.designpatterns.observer.taskmanagementapp.TaskObserver;
import org.backend.session.lld2.designpatterns.observer.taskmanagementapp.notification.NotificationUtils;

public class SlackService implements TaskObserver {
    @Override
    public void notify(Long userId, Long taskId) {
        String subject = "New task assigned";
        String message = "Task %s assigned to user %s";
        NotificationUtils.sendSlack(subject, String.format(message, taskId, userId));

    }
}
