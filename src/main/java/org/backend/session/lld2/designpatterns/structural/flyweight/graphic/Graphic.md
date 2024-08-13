# Flyweight Pattern

## Problem Statement

You are working on a graphical editing software. The application must support rendering text with different fonts, sizes, and colors. The application must also support rendering images with different dimensions and formats. Joe is concerned about the memory overhead of creating multiple text and image objects with the same state.

## Assignment

Your task is to implement the Flyweight pattern to optimize the memory usage of graphical elements in the editing software. The Flyweight pattern aims to share common state between multiple objects to reduce memory consumption.

### Task 1 - Intrinsic and Extrinsic State Separation

In the Flyweight pattern, objects are split into intrinsic state (shared and independent of the context) and extrinsic state (variable and dependent on the context). Your task is to refactor the initial `Graphic` class into two separate classes: `GraphicIntrinsicState` and `GraphicExtrinsicState`.

`GraphicIntrinsicState` class:
- Create a class named `GraphicIntrinsicState` with appropriate fields to represent the intrinsic state of a graphic element. You have been given an empty class.
- Annotate this class with the `@IntrinsicState` annotation.

`GraphicExtrinsicState` class:
- Create a class named `GraphicExtrinsicState` with appropriate fields to represent the extrinsic state of a graphic element. You have been given an empty class.
- Annotate this class with the `@ExtrinsicState` annotation.

### Task 2 - Implementing the registry pattern

To make the storage and usability of the flyweight easier, implement the registry pattern
- Create a registry class to implement the interface `FlyweightRegistry`.
- The class should store the flyweight and fetch the relevant flyweight based on the type.


### Instructions

1. Implement the `GraphicIntrinsicState` and `GraphicExtrinsicState` by breaking the original class into intrinsic and extrinsic state.
2. Ensure that both classes are annotated with the appropriate annotations i.e. `@IntrinsicState` and `@ExtrinsicState`.
3. Implement the registry interface's `FlyweightRegistry` add and get flyweight methods.
4. Run the provided test cases in the `GraphicTest` class to verify the correctness of your implementation. You are not required to edit the test cases themselves.