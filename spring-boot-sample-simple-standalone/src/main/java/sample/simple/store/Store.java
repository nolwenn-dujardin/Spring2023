package sample.simple.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.bank.IBank;
import sample.simple.provider.IProvider;

@Component
public class Store implements IJustHaveALook, IFastLane, ILane {

    @Autowired
    IBank bank;

    @Autowired
    IProvider provider;

    @Override
    public void oneShotOrder() {
        System.out.println("One shot order...");
        addItemToCart();
        pay();

        System.out.println("Checking stock...");
        isAvailable();
        System.out.println("Ordering...");
        provider.getPrice();
        provider.order();
    }

    @Override
    public int getPrice() {
        System.out.println("Price : 5€");
        return 0;
    }

    @Override
    public boolean isAvailable() {
        System.out.println("Product available");
        return true;
    }

    @Override
    public void addItemToCart() {
        System.out.println("Add article to cart");
    }

    @Override
    public void pay() {
        System.out.println("Paying...");
        bank.transfert();
    }
}
