package org.backend.session.lld2.designpatterns.decorator.icecream;

public class OrangeCone implements IceCream{

    //This orangeCone is only acting as base ingredient

    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Orange Cone";
    }
}
