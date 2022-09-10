package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdfb = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data:");
        System.out.print("Name:");
        String clientName = sc.next();
        System.out.print("Email:");
        String clientEmail = sc.next();
        System.out.print("Birth date (DD/MM/YYYY):");
        String clientBirth = sc.next();
        System.out.print("Enter order Status: ");
        String orderStatus = sc.next();
        //Pedidio Instanciado.
        Order order = new Order(new Client(clientName, clientEmail, sdfb.parse(clientBirth)),
                OrderStatus.valueOf(orderStatus));

        //Instanciação de ordem de produto.
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            System.out.println("Enter #" +(i+1) + " item data:");
            System.out.print("Product name:");
            String pName = sc.next();
            System.out.print("Product price:");
            Double pPrice = sc.nextDouble();
            System.out.print("Quantity:");
            Integer pQuantity = sc.nextInt();
            Product p = new Product(pName,pPrice);
            OrderItem o = new OrderItem(pQuantity,p);
            order.addItem(o);
        }
        //Sumario
        System.out.println(order);
    }

}
