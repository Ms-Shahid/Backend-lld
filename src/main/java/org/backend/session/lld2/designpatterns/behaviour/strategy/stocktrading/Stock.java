package org.backend.session.lld2.designpatterns.strategy.stocktrading;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Stock {
    private Double price;
    private Double previousPrice;
}
