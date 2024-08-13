package org.backend.session.lld2.designpatterns.strategy.stocktrading;

public class Volatility implements TradingIndicatorStrategy{

    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.VOLATILITY;
    }

    @Override
    public Double calculateTradingIndicator(Stock stock) {
        return Math.abs(stock.getPrice() - stock.getPreviousPrice());
    }
}
