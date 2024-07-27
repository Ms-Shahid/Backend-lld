# Simple Factory Pattern for Document Processing

## Problem Statement

You are designing a document processing application. Depending on the type of document (e.g., text, spreadsheet, presentation), different processing routines are required. You need a way to create document processors without explicitly specifying their classes, ensuring the application is open for future document types.

## Assignment

Your task is to implement the Simple Factory pattern to create document processors in the document processing application. The Simple Factory pattern provides a way to create objects without exposing the instantiation logic, allowing for easy addition of new document processor types.

### Task 1 - Creating a Common Parent Class - Product Hierarchy

To streamline the creation of document processors, implement the common parent class named `DocumentProcessor`. This class should include attributes and methods that are common to all document processors. The method `supportsType` has already been abstracted out for you as an example. You will need to implement the `DocumentProcessor` class as a common parent class for all document processors.

### Task 2 - Implementing the Simple Factory

Implement a `DocumentProcessorFactory` class that follows the Simple Factory pattern. This class should have a method to create document processors based on the `DocumentType`. The factory class should be capable of creating different types of document processors based on the `DocumentType`. Also remember that to create a document processor, you need to pass the document name as a parameter as well.

### Instructions

1. Implement the `DocumentProcessor` class as a common parent class for all document processors. Include attributes and methods that are common to all document processors.

2. Implement the `DocumentProcessorFactory` class that implements the Simple Factory pattern. Add a method to create document processors based on `DocumentType` and other parameters.

3. Run the provided test cases in the `DocumentProcessorTest` class to verify the correctness of your implementation. The tests will check if all document processors have a common parent class and if the factory class can correctly create document processors based on the document type and name.