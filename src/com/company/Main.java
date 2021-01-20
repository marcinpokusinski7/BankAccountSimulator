package com.company;

import java.util.Scanner;

public class Main {
        private static Scanner scanner = new Scanner(System.in);
        private static BankSystem bankSystem = new BankSystem();
    public static void main(String[] args) {
        boolean quit = false;
        printActions();
            while (!quit){
                System.out.println("Enter actions: (press 6 to show available actions)");
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action){
                    case 0:
                        System.out.println("\nShutting down");
                        quit = true;
                        break;
                    case 1:
                        bankSystem.printAccounts();
                        break;
                    case 2:
                        createNewAccount();
                        break;
                    case 3:
                        removeAccount();
                        break;
                    case 6:
                        printActions();
                        break;
                }
            }


    }
    public static void createNewAccount(){
        System.out.println("Enter account owner name: ");
        String accountOwner = scanner.nextLine();
        System.out.println("Enter new account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter new deposit: ");
        int balance = scanner.nextInt();
        Account account = Account.createAccount(accountNumber,balance,accountOwner);
        if(bankSystem.createAccount(account)){
            System.out.println("New account created: " +accountOwner +" " +accountNumber +" "+balance);

        }else {
            System.out.println("Cannot add" +accountNumber + "already exists");
        }
    }

    public static void removeAccount(){
        System.out.println("Enter accout number: ");
        String accountNumber = scanner.nextLine();
        Account existingAccount = bankSystem.queryAccount(accountNumber);
        if(existingAccount == null){
            System.out.println("Account not found");
            return;
        }
        if(bankSystem.removeAccount(existingAccount)){
            System.out.println("Deleted");
        }else {
            System.out.println("error deleting");
        }
    }


    public static void printActions(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print existing accounts.\n" +
                "2 - to create new account.\n" +
                "3 - to remove existing account.\n" +
                "6 - show available actions.\n");
    }
}
