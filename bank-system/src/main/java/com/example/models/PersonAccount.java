package com.example.models;
 // Wrapper class combining Person and Account
public class PersonAccount {
    private Person person;
    private BankAccount bankAccount;

    public PersonAccount(Person person, BankAccount bankAccount) {
        this.person = person;
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return person.getName();
    }

    public int getAge() {
        return person.getAge();
    }

    public String getId() {
        return person.getId();
    }

    public String getAccountNumber() {
        return bankAccount.getAccountNumber();
    }

    public double getBalance() {
        return bankAccount.getBalance();
    }
}
