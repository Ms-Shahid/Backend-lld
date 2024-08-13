# Strategy Pattern for Stock Trading Indicators

## Problem Statement
You are tasked with refactoring a stock trading application. The application currently calculates various trading indicators such as moving averages, momentum, and volatility. These indicators are used to make decisions about buying, selling, or holding stocks. However, the current implementation relies on a single class, making it challenging to extend and maintain as new indicators are added. To address this, you need to refactor the application to use the Strategy pattern. This pattern allows you to encapsulate each trading indicator as a separate strategy and easily switch between them without modifying the core trading algorithm.

## Assignment
Your task is to refactor the `StockTradingManager` class to use the Strategy pattern for calculating trading indicators. You should create separate strategy classes for each trading indicator (Moving Averages, Momentum, and Volatility) that implement a common interface. Each strategy should define its calculation method for the respective indicator. The `StockTradingManager` class should utilize these strategies to calculate indicators based on the selected strategy type. Additionally, each strategy should provide a method to check if it supports a specific indicator type.

## Implementing the Strategy Pattern

1. **Create a Strategy Interface**: Define a common interface, e.g., `TradingIndicatorStrategy`, that declares a method for calculating the trading indicator and another method for checking if the strategy supports a specific indicator type.

2. **Implement Concrete Strategies**: Create concrete strategy classes for each trading indicator (Moving Averages, Momentum, and Volatility). Implement the methods defined in the `TradingIndicatorStrategy` interface for calculating the respective indicators. Ensure that each strategy class also implements the `supportsType` method to specify which indicator type it supports.

3. **Refactor `StockTradingManager`**: Modify the `StockTradingManager` class to accept a `TradingIndicatorStrategy` instead of a `TradingStrategyType`. The `calculateIndicator` method should delegate the calculation to the selected strategy.

4. **Copy Existing Logic**: For each strategy, copy the existing indicator calculation logic from the original `StockTradingManager` class into the corresponding strategy class.

5. **Test Your Implementation**: Write test cases to ensure that each strategy correctly calculates the corresponding indicator, and that the `StockTradingManager` class works seamlessly with different strategies.

## Trading Indicator Calculations

1. **Moving Averages**: This indicator calculates the average of a stock's price and its previous price. It can help identify trends by smoothing out price fluctuations.

2. **Momentum**: Momentum is the difference between the current stock price and its previous price. It provides insights into the stock's rate of change.

3. **Volatility**: Volatility measures the magnitude of price fluctuations in a stock. It calculates the absolute difference between the current price and the previous price.

## Instructions

1. Refactor the `StockTradingManager` class to use the Strategy pattern by implementing separate strategy classes for each trading indicator.
2. Ensure that each strategy class correctly implements the `TradingIndicatorStrategy` interface and supports the respective indicator type.
3. Copy the existing indicator calculation logic from the original `StockTradingManager` class into the corresponding strategy classes.
4. Write test cases to validate that each strategy calculates the indicator correctly, and that the `StockTradingManager` class works as expected with different strategies.