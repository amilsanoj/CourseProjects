package entities;

public class Individual extends TaxProfile {
    private Double medicalPay;

    public Individual(String name, Double income, Double medicalPay) {
        super(name, income);
        this.medicalPay = medicalPay;
    }

    @Override
    public Double tax(){
        double tax;
        if (income < 20000){
            tax = income*0.15;
        } else {
            tax = (income*0.25) - (medicalPay*0.5);
        }
        return tax;
    }
}
