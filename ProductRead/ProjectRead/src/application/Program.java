package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();


        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Product #"+ i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            switch (ch){
                case 'u' :
                    System.out.print("Manufacture date (DD/MM/YYYY):");
                    String date = sc.next();
                    LocalDate localDate = LocalDate.parse(date,fmt1);
                    list.add(new UsedProduct(name, price, localDate));
                    break;
                case 'i' :
                    System.out.print("Customs fee: ");
                    double customFee = sc.nextDouble();
                    list.add(new ImportedProduct(name, price, customFee));
                    break;
                default:
                    list.add(new Product(name, price));
                    break;
            }
        }
        System.out.println();
        System.out.println("Price Tags: ");
        for (Product p : list){
            System.out.println(p.priceTag());
        }

    }
}
