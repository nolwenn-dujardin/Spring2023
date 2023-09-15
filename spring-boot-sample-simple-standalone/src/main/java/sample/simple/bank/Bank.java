package sample.simple.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank{
    @Override
    public void transfert() {
        System.out.println("The transfer is beginning.");
    }
}
