package org.backend.session.lld2.designpatterns.strategy.stocktrading;

public class StockTradingManager {

    private TradingStrategyType strategyType;
    private TradingIndicatorStrategy indicatorStrategy;

    public StockTradingManager(TradingStrategyType strategyType, TradingIndicatorStrategy indicatorStrategy) {
        this.strategyType = strategyType;
        this.indicatorStrategy = indicatorStrategy;
    }

    public Double calculateIndicator(Stock stock) {
        switch (strategyType) {
            case MOVING_AVERAGES, MOMENTUM, VOLATILITY:
                return indicatorStrategy.calculateTradingIndicator(stock);
        }
        throw new RuntimeException("Invalid strategy type");
    }
}
