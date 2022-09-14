package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class UsedProduct extends Product{
    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate localDate;

    public UsedProduct(String name, Double price, LocalDate date) {
        super(name, price);
        this.localDate = date;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String priceTag(){
        return getName() + " (Used) $ " + getPrice() + " (Manufacture Date: " + getLocalDate().format(fmt1)+")";
    }
}
