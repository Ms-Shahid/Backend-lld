package org.backend.session.lld2.designpatterns.strategy.stocktrading;

public class Momentum implements TradingIndicatorStrategy{
    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.MOMENTUM;
    }

    @Override
    public Double calculateTradingIndicator(Stock stock) {
        return stock.getPrice() - stock.getPreviousPrice();
    }
}
