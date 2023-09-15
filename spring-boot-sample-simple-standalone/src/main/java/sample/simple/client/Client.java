package sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;

@Component
public class Client implements IRun {
    @Autowired
    IFastLane fastLane;

    @Autowired
    ILane lane;

    @Autowired
    IJustHaveALook justHaveALook;

    @Override
    public void run() {
        System.out.println("Check article...");
        justHaveALook.getPrice();
        justHaveALook.isAvailable();
        fastLane.oneShotOrder();
    }
}
