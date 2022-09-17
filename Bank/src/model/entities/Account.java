package model.entities;

import model.exepction.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        if(balance < 0){
            throw new DomainException("Account balance isn't negative ");
        }
        if(withdrawLimit < 0){
            throw new DomainException("Withdraw limit isn't negative ");
        }
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount){
        if (amount > withdrawLimit){
            throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > balance){
            throw new DomainException("Withdraw error: Not enough balance");
        }
        balance -= amount;
        System.out.println("New balance: " + balance);

    }

}
