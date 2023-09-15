package sample.simple.provider;

import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider{
    @Override
    public int getPrice() {
        System.out.println("The product costs 5€");
        return 0;
    }

    @Override
    public void order() {
        System.out.println("Order begins...");
        System.out.println();
        System.out.println("Order ends");
    }
}
