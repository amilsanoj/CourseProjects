package entities;

public abstract class TaxProfile {
    private String name;
    protected Double income;

    public TaxProfile(String name, Double income) {
        this.name = name;
        this.income = income;
    }

    public Double tax(){
        return null;
    }

    public String toString(){
        return name + String.format(": $ %.2f", tax());
    }
}
