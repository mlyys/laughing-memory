package com.example.models;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {
    private String id;
    private String name;
    private int age;
    private ObservableList<BankAccount> bankAccounts;

    public void addAccount(BankAccount account){
        this.bankAccounts.add(account);
        account.setPerson(this);
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

    public ObservableList<BankAccount> getBankAccounts() {
        return FXCollections.unmodifiableObservableList(bankAccounts);
        }

    public Person (String id, String name, int age) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.bankAccounts = FXCollections.observableArrayList();
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

        /* public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
*/

}