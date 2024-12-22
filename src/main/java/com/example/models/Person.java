package com.example.models;

import java.util.ArrayList;

public class Person {
    private String id;
    private String name;
    private int age;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public void addAccount(BankAccount account){
        bankAccounts.add(account);
    }

    public BankAccount findAccount(String accountNumber){
        for (BankAccount account: bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; 
    }

    public double calculateTotalBalance() {
        double balance = 0.0;
        for (BankAccount account: bankAccounts) {
            balance += account.getBalance();
        }
        return balance;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Person (String id, String name, int age) {
        this.id=id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

}
