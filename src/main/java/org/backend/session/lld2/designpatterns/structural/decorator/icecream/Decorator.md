
### Decorator Design Pattern
> This pattern is used, when you have to add on requirements at runtime, provided that you have a base add on.


- Lets say, you have an ice-cream, as per the requirements the cone is mandatory & only a cone can be act as ice-cream
- So here, just the cone( any favour) is base entity or base Addon 
- As note that, cone can also be acted as base addon & normal addon
- The remaining ingredients( syrup, scoop, cheery ) acts as optional addons

> The Decorator specific that, your base addon can have the reference of interface( in this case ice-cream ) in constructor & the optional addons must have the interface reference in constructor

**Example** :

- IceCream(main entity) is a main Interface, all the addons(base & optionals) must implement this interface.
```java
  public interface IceCream {
    int getCost();

    String getDescription();
}
```
- Now, say ChocoChip is an optional addon, so this class must have a reference of IceCream interface in its constructor, So that object of this addon can't be created without passing the IceCream reference ( IceCream is an dependency for ChocoChip )
```java
  public class ChocoChips implements IceCream {
    private IceCream iceCream;

    public ChocoChips(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        if (iceCream != null) { //Always check for NPE.
            return iceCream.getCost() + 5;
        }
        return 0; // Invalid or throw an exception
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " + Choco Chips";
    }
}
  ```
- Now, say we have a OrangeCone, which has only Override methods without any IceCream reference in its constructor, which means that this is the Base addon ( oragneCone alone can be considered as IceCream (as per requirement))
```java
public class OrangeCone implements IceCream {
    //OrangeCone will only behave like a base
    @Override
    public String getDescription() {
        return "Orange Cone";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
```
- Similarly, we have addons such as StrawberryScoop which is on optional addon
```java
  public class StrawberryScoop implements IceCream {
    private IceCream iceCream;

    public StrawberryScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " + Strawberry Scoop";
    }

    @Override
    public int getCost() {
        return iceCream.getCost() + 30;
    }
}
```
- And, VanillaScoop as an optional addon 
```java
public class VanillaScoop implements IceCream {
    private IceCream iceCream;

    public VanillaScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " + Vanilla Scoop";
    }

    @Override
    public int getCost() {
        return iceCream.getCost() + 40;
    }

}
```

- The Customer/Client class will look like, which says, 
```java
public class Client {
    public static void main(String[] args) {
        IceCream iceCream =
                new ChocoChips(
                        new StrawberryScoop(
                                new ChocolateCone(
                                        new ChocoChips(
                                                new OrangeCone()
                                        )
                                )
                        )
                );

        System.out.println(iceCream.getDescription());
        System.out.println(iceCream.getCost());
    }
}
```
- OrangeCone (base addon) with its own cost & description, on top of it we add ChocoChips (optional addon), now the cost will be cost of ChocoChips + IceCream Cost( OrangeCone cost) OrangeCone is acting as a dependency in constructor of ChocoChips.

The Order of execution will be,
> OrangeCone + ChocoChips + ChocolateCone + StrawberryScoop + ChocoChips => IceCream


## **[Real World use case](https://docs.google.com/document/d/1aGMknAFiz4LSUuMMxZ8gJOoXWl166QLVsdcaCpB-UV0/edit)**

