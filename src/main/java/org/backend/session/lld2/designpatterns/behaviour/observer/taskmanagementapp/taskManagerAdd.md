# Observer Pattern for Task Management Application

## Problem Statement
You are building a task management application where users can create tasks and assign them to different team members. To enhance the user experience, Joe, a developer on your team, wants to implement a feature where team members receive notifications whenever they are assigned a new task. These notifications should be sent through various communication channels, such as in-app alerts, emails, and Slack messages. Joe believes that implementing the Observer pattern will provide a flexible and maintainable solution for this requirement.

## Assignment
Your assignment is to implement the Observer pattern to create a flexible notification system for the task management application. The `TaskManager` class handles task assignments, and various observer classes (e.g., `AlertService`, `EmailService`, `SlackService`) need to be notified when a new task is assigned to a team member.

## Implementing the Observer Pattern

1. **Understand the original class**: Take a closer look at the `TaskManager` class and its interactions with the task database and notification services. Understand how tasks are assigned and notifications are sent.

2. **Implement the observer interface**: Implement the interface named `Observer` with a method that accepts the task and the team member as arguments. Observer classes (such as `AlertService`, `EmailService`, `SlackService`) will implement this interface to receive notifications.

3. **Implement the publisher interface**: You have been provided with a `Publisher` abstract class. Your task is to implement the methods required by this interface in the `TaskManager` class. The `Publisher` interface defines methods that allow observers to subscribe and unsubscribe.

4. **Modify the observers**: Refactor the observer classes to implement the `Observer` interface. Update their existing methods to match the new interface method signature.

5. **Modify the publisher**: Refactor the `TaskManager` class as required. Implement the publisher methods to manage observer subscriptions and notify observers when a task is assigned.

6. **Test your implementation**: Run the provided test cases in the `TaskManagerTest` class to ensure that your observer pattern implementation is correct. These test cases will check if observers are being notified correctly and if the `TaskManager` behaves as expected.

## Instructions

1. Implement the Observer pattern by creating the `Observer` interface, modifying the observer classes (`AlertService`, `EmailService`, `SlackService`), and updating the `TaskManager` class.
2. Run the provided test cases in the `TaskManagerTest` class to verify the correctness of your observer pattern implementation.