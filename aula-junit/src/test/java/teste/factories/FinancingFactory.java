package teste.factories;

import entities.Financing;

public class FinancingFactory {

    public static Financing buildEmptyFinancing(){
        Financing financing = new Financing();
        financing.setId(1L);
        return financing;
    }

    public static Financing buildFinancing(double totalAmounts, double income, Integer months){
        return new Financing(1L, totalAmounts, income, months);
    }

}
