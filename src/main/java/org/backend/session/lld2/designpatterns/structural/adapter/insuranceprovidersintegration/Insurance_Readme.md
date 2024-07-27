# Adapter Pattern for Insurance Providers Integration

## Problem Statement
Your company needs to integrate with various insurance providers, each having different APIs and data formats. To simplify the integration and ensure a consistent data format, you decide to implement the Adapter pattern. This pattern will allow you to create adapter classes for different insurance providers, converting their APIs into a common format that your application can use.

## Assignment
Your task is to implement the Adapter pattern to create adapter classes for different insurance providers' APIs. These adapters should conform to a common interface, making it easy to integrate new providers in the future. Your goal is to abstract away the differences in APIs and data formats and provide a unified interface for your application to work with.

## Implementing the Adapter Pattern

1. **Review the existing APIs**: Study the APIs and data formats of the insurance providers you need to integrate with. Understand the differences in their APIs and how they interact with their respective systems.

2. **Implement the adapter interface**: You have been provided with an `TravelInsuranceAdapter` interface. Your task is to implement this interface in different adapter classes, each corresponding to a different insurance provider. The adapters should adapt the provider-specific APIs into a format that matches the `TravelInsuranceAdapter` interface.

3. **Use composition**: Create adapter classes that internally use instances of the actual insurance provider APIs. You should not modify the provider APIs directly. Instead, create methods in the adapter classes that map to the provider APIs and perform the necessary transformations.

4. **Test your implementation**: Run the provided test cases in the `TravelInsuranceAdapterTest` class to ensure that your adapter classes work correctly. These test cases will check if your adapters have the required methods and if they interact with the provider APIs properly.

## Instructions
1. Implement the Adapter pattern by creating adapter classes that implement the `TravelInsuranceAdapter` interface and adapt the APIs of different insurance providers.
2. Run the provided test cases in the `TravelInsuranceAdapterTest` class to verify the correctness of your adapter pattern implementation. Make sure your adapters have the expected methods and interact with the provider APIs as required.