package sample.aop.part1.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.aop.part1.store.IFastLane;
import sample.aop.part1.store.IJustHaveALook;
import sample.aop.part1.store.ILane;

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
