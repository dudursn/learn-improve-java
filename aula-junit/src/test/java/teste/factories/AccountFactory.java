package teste.factories;

import entities.Account;

public class AccountFactory {

    public static Account buildEmptyAccount(){
        return new Account(1L, 0.0);
    }

    public static Account buildAccount(double initialBalance){
        return new Account(1L, initialBalance);
    }
}
