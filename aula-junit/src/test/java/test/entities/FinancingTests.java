package test.entities;

import entities.Account;
import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import teste.factories.AccountFactory;
import teste.factories.FinancingFactory;

public class FinancingTests {

    @Test
    public void createShouldReturnFinancingObjectWhenFinancingIsValid(){

        Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
        Assertions.assertEquals(Financing.class, financing.getClass());
    }

    @Test
    public void createShouldThrowExceptionWhenFinancingIsInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 20);
        });
    }

    @Test
    public void setTotalAmountShouldSetValueWhenFinancingIsValid(){
        double expectedValue = 80000;
        Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
        financing.setTotalAmounts(expectedValue);

        Assertions.assertEquals(expectedValue, financing.getTotalAmounts());
    }

    @Test
    public void setTotalAmountShouldThrowExceptionWhenFinancingIsInValid(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{

            Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
            financing.setTotalAmounts(150000);
        });
    }

    @Test
    public void setIncomeShouldSetValueWhenFinancingIsValid(){
        double expectedValue = 4000.0;
        Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
        financing.setIncome(expectedValue);

        Assertions.assertEquals(expectedValue, financing.getIncome());    }

    @Test
    public void setIncomeShouldThrowExceptionWhenFinancingIsInValid(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
            financing.setIncome(1500.0);
        });
    }

    @Test
    public void setMonthsShouldSetValueWhenFinancingIsValid(){
        Integer expectedValue = 100;
        Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
        financing.setMonths(expectedValue);

        Assertions.assertEquals(expectedValue, financing.getMonths());
    }

    @Test
    public void setMonthsShouldThrowExceptionWhenFinancingIsInValid(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
            financing.setMonths(20);
        });
    }

    @Test
    public void entryShouldReturnCorrectValueWhenFinancingIsValid(){
        double expectedValue = 20000.0;
        Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
        Assertions.assertEquals(expectedValue, financing.entry());
    }

    @Test
    public void quotaShouldReturnCorrectValueWhenFinancingIsValid(){
        double expectedValue = 1000.00;
        Financing financing = FinancingFactory.buildFinancing(100000.0, 2000.0, 80);
        Assertions.assertEquals(expectedValue, financing.quota());

    }


}
