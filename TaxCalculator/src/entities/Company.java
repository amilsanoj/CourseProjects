package entities;

public class Company extends TaxProfile {
    private Integer empQuantity;

    public Company(String name, Double income, Integer empQuantity) {
        super(name, income);
        this.empQuantity = empQuantity;
    }

    @Override
    public Double tax(){
        double tax;
        if (empQuantity < 10){
            tax = income*0.16;
        } else {
            tax = income*0.14;
        }
        return tax;
    }
}
