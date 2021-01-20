package com.company;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountOwner;


    public Account(String accountNumber, double balance, String accountOwner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountOwner = accountOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public static Account createAccount(String accountNumber, double balance, String accountOwner
    ){
        return new Account(accountNumber,balance ,accountOwner);
    }
}
