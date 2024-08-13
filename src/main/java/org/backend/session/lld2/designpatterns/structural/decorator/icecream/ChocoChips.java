package org.backend.session.lld2.designpatterns.decorator.icecream;

//Add Ons
public class ChocoChips implements IceCream{

    private final IceCream iceCream;

    public ChocoChips(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        if( iceCream != null ){ //Ad ons shouldn't be null
            return iceCream.getCost() + this.getCost();
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "Choco Chips";
    }
}
