package entities;

public class Financing {

    private static double FINANCE_PERCENTAGE = 0.2;

    private Long id;
    private Double totalAmounts;
    private Double income;
    private Integer months;

    public Financing() {
    }

    public Financing(Long id, Double totalAmounts, Double income, Integer months) {
        validate(totalAmounts, income, months);
        this.id = id;
        this.totalAmounts = totalAmounts;
        this.income = income;
        this.months = months;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(double totalAmounts) {
        validate(totalAmounts, income, months);
        this.totalAmounts = totalAmounts;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        validate(totalAmounts, income, months);
        this.income = income;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        validate(totalAmounts, income, months);
        this.months = months;
    }

    public double entry() {
        return totalAmounts * FINANCE_PERCENTAGE;
    }

    public double quota(){
        return (totalAmounts - entry()) / months;
    }

    private void validate(double totalAmounts, double income, Integer months){
        double quotaValue = (totalAmounts * (1-FINANCE_PERCENTAGE)) / months;
        if(2*quotaValue > income){
            throw new IllegalArgumentException();
        }
    }
}
