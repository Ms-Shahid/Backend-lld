# Flyweight Pattern for Chess User Optimization

## Problem Statement

You are developing a chess game application where you need to represent individual chess users with various attributes like name, age, gender, email, and more.
One user can play multiple games simultaneously. At the moment, you create a new user object for each game.
Each user object consumes memory, and you want to optimize the memory usage by only keeping one copy of fields that do not change.

You need to implement the Flyweight pattern to efficiently manage and reuse shared attributes while keeping individual user-specific data separate.

## Assignment

Your task is to implement the Flyweight pattern to optimize the memory usage of chess user objects in your application. The Flyweight pattern aims to share common intrinsic state between multiple objects to reduce memory consumption while keeping extrinsic state (variable and context-dependent) separate for each object.
Look closely at the `ChessUser` class and identify which fields are going to be different amongst different games and which ones will be the same.

### Task 1 - Intrinsic and Extrinsic State Separation

In the Flyweight pattern, objects are divided into intrinsic state (shared and independent of the context) and extrinsic state (variable and dependent on the context). Your task is to refactor the `ChessUser` class into two separate classes: `ChessUserIntrinsicState` and `ChessUserExtrinsicState`.

`ChessUserIntrinsicState` class:
- Create a class named `ChessUserIntrinsicState` with appropriate fields to represent the intrinsic state of a chess user. You have been given an empty class.
- Annotate this class with the `@IntrinsicState` annotation to mark it as the intrinsic state container.

`ChessUserExtrinsicState` class:
- Create a class named `ChessUserExtrinsicState` with appropriate fields to represent the extrinsic state of a chess user. You have been given an empty class.
- Annotate this class with the `@ExtrinsicState` annotation to indicate it contains the extrinsic state.

### Task 2 - Implementing the Flyweight Registry

To make the storage and retrieval of flyweight objects easier, implement a registry pattern.

- Create a registry class that implements the `FlyweightRegistry` interface.
- This class should manage the flyweight objects and provide methods to add and retrieve flyweights based on their type.

### Instructions

1. Implement the `ChessUserIntrinsicState` and `ChessUserExtrinsicState` classes by separating the original `ChessUser` class into intrinsic and extrinsic state.
2. Ensure that both classes are annotated with the appropriate annotations, i.e., `@IntrinsicState` and `@ExtrinsicState`.
3. Implement the registry class according to the `FlyweightRegistry` interface. This class should store and provide access to flyweight objects based on their type.
4. Run the provided test cases in the `ChessUserTest` class to validate the correctness of your Flyweight pattern implementation. You are not required to modify the test cases themselves.