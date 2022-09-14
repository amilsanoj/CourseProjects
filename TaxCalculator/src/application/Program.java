package application;

import entities.Company;
import entities.Individual;
import entities.TaxProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxProfile> list = new ArrayList<>();


        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual Income: ");
            double income = sc.nextDouble();
           if (ch == 'i'){
               System.out.print("Health expenditures: ");
               double medicalPay = sc.nextDouble();
               list.add(new Individual(name, income, medicalPay));
           } else {
               System.out.print("Number of employees: ");
               int empQuantity = sc.nextInt();
               list.add(new Company(name, income, empQuantity));
           }
        }
        double sum = 0;
        System.out.println();
        System.out.println("TAXES PAID: ");
        for (TaxProfile taxProfile : list){
            double tax = taxProfile.tax();
            System.out.println(taxProfile);
            sum += tax;

        }

        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

    }
}
