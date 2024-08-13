package org.backend.session.lld2.designpatterns.strategy.stocktrading;

public interface TradingIndicatorStrategy {
    TradingStrategyType supportsType();
    Double calculateTradingIndicator(Stock stock);
}
