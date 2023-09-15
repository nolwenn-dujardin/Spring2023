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

    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void addItemToCart() {

    }

    @Override
    public void pay() {

    }
}
