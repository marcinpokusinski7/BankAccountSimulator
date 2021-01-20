package com.company;

import java.util.ArrayList;

public class BankSystem {
    private ArrayList<Account> createdAccount;

    public BankSystem() {
        this.createdAccount = new ArrayList<Account>();
    }


    public boolean createAccount(Account account){
        if(findAccount(account.getAccountNumber())>=0){
            System.out.println("Account already exists");
            return false;
        }
        createdAccount.add(account);
        return true;
    }

    public boolean removeAccount(Account account){
        for(int i = 0; i< createdAccount.size();i++){
            account = this.createdAccount.get(i);
            if(createdAccount.get(i).getAccountNumber().equals(account.getAccountNumber())){
                createdAccount.remove(account);
                return true;
            }
        }
        return false;
    }

    private int findAccount(Account account){
        return this.createdAccount.indexOf(account);//zwraca indeks - numer listy konta
    }

    private int findAccount(String accountNumber){
      for(int i = 0 ; i < this.createdAccount.size();i++){
          Account account = this.createdAccount.get(i);
          if(account.getAccountNumber().equals(accountNumber)){
              return i;
          }
      }
      return -1;
    }
    public Account queryAccount(String accountNumber){
        int position = findAccount(accountNumber);
        if(position >= 0){
            return this.createdAccount.get(position);
        }
        return null;
    }
    public void printAccounts(){
        System.out.println("Accounts List");
        for(int i = 0; i<this.createdAccount.size();i++){
            System.out.println((i+1)+". Name: " +createdAccount.get(i).getAccountOwner()+
            " -> " +createdAccount.get(i).getAccountNumber() +" balance: " +createdAccount.get(i).getBalance());
        }
    }

}
