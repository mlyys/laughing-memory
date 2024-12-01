package com.example.models;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private Person person;

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
    }

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.person = null;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
