package entities;

public class Account {

    private static double DEPOSIT_FEE_PERCENTAGE = 0.02;

    private Long id;
    private Double balance;

    public Account(Long id, Double balance) {
        super();
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double amount) {
        if(amount > 0) {
            amount = amount - (amount * DEPOSIT_FEE_PERCENTAGE);
            this.balance += amount;
        }
    }

    public void withdraw(Double amount) {
        if(amount > this.balance) {
            throw new IllegalArgumentException();
        }
        this.balance -= amount;
    }

    public double fullWithDraw(){
        double aux = this.balance;
        this.balance = 0.00;
        return aux;
    }


}
