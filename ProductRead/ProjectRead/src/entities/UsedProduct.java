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

    @Override
    public String priceTag(){
        return name + " (Used) $ " + String.format("%.2f",price) + " (Manufacture Date: " + localDate.format(fmt1)+")";
    }
}
