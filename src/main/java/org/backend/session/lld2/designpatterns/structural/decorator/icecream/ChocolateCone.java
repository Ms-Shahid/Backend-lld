package org.backend.session.lld2.designpatterns.decorator.icecream;

//Base class : Base & can also act as ad on
public class ChocolateCone implements IceCream{

    private IceCream iceCream;

    public ChocolateCone(){ } //Here acting as base ad on

    public ChocolateCone(IceCream iceCream){ //Normal Ad on
        this.iceCream = iceCream;
    }


    @Override
    public int getCost() {
        if( iceCream != null ){
            return iceCream.getCost() + 30; //30 is base cost
        }
        return 30;
    }

    @Override
    public String getDescription() {
        if( iceCream != null )
            return iceCream.getDescription() + " Chocolate Cone";
        return "ChocolateCone";
    }
}
