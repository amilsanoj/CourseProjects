package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItem = new ArrayList<>();

    public Order(Client client, OrderStatus status) {
        this.client = client;
        this.moment = new Date();
        this.status = status;
    }


    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(OrderItem orderItem){
        this.orderItem.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        this.orderItem.remove(orderItem);
    }

    public Double total(){
        double total = 0;
        for(OrderItem oi: orderItem){
           total += oi.subTotal();
        }
        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:"+"\n" );
        sb.append("Order moment: ");
        sb.append(sdf.format(moment)+ "\n" );
        sb.append("Status: " );
        sb.append(status()+"\n" );
        sb.append("Client: ");
        sb.append(client+"\n" );
        sb.append("Order Items: "+"\n" );
        for (OrderItem oi : orderItem) {
            sb.append(oi+"\n" );
        }
        sb.append(total());
        return sb.toString();
    }

}
