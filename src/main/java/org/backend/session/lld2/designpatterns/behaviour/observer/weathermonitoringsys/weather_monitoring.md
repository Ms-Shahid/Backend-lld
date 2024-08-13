# Observer Pattern for Weather Monitoring System

## Problem Statement
You are developing a weather monitoring system that collects data from various sensors such as temperature, humidity, and pressure sensors. When any sensor reading goes beyond a predefined threshold, you need to notify different weather stations through various communication channels like emails, SMS, and push notifications. Your task is to implement the Observer pattern to create a flexible notification system for this weather monitoring system.

## Assignment
Your goal is to implement the Observer pattern to refactor the existing `WeatherMonitoringApplication` class. The current class handles weather condition updates and notifications. Observer classes (e.g., `TemperatureService`, `PressureService`, `HumidityService`) need to be notified when any of the weather readings go beyond their respective thresholds.

## Implementing the Observer Pattern

1. **Review the original class**: Study the `WeatherMonitoringApplication` class and its dependencies. Understand how it currently handles weather condition updates and notifications.

2. **Implement the publisher class**: You have been provided with a `Publisher` abstract class. Implement the required methods defined by this interface in the `WeatherMonitoringApplication` class. Remember that the `Publisher` interface defines the methods that a class can use to notify observers.

3. **Implement the observer interface**: Create an interface named `Observer` with a method that takes the weather conditions (e.g., temperature, humidity, pressure) as arguments. Observer classes (e.g., `TemperatureService`, `PressureService`, `HumidityService`) will implement this interface to receive notifications.

4. **Refactor the publisher**: Modify the `WeatherMonitoringApplication` class to adhere to the Observer pattern. **Do not change the constructor signature** as it's used by the tests.

5. **Refactor the observers**: Update the observer classes to implement the `Observer` interface. Modify their existing methods to match the new interface method signature.

6. **Test your implementation**: Run the provided test cases in the `WeatherMonitoringTests` class to verify that your observer pattern implementation works correctly. These test cases will check if observers are notified appropriately and if the `WeatherMonitoringApplication` functions as expected.

## Instructions

1. Implement the Observer pattern by completing the `Publisher` and `Observer` interfaces and modifying the observer classes (`TemperatureService`, `PressureService`, `HumidityService`) and the `WeatherMonitoringSystem` class.
2. Run the provided test cases in the `WeatherMonitoringTests` class to verify the correctness of your observer pattern implementation.