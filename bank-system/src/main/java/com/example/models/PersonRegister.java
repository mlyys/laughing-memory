package com.example.models;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonRegister {
    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();


    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findPerson(String id) {
        for (Person findPerson : persons) {
            if (findPerson.getId().equals(id)) {
                return findPerson;
            }
        }
        return null;
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account: bankAccounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public double calculateTotalBalance() {
        double balance = 0.0;
        for (BankAccount account : bankAccounts) {
            balance += account.getBalance();
        }
        return balance;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

        public ObservableList<PersonAccount> getPersonAccounts() {
        ObservableList<PersonAccount> personAccounts = FXCollections.observableArrayList();
        for (Person person : persons) {
            for (BankAccount account : person.getBankAccounts()) {
                personAccounts.add(new PersonAccount(
                    person, account));
            }
        }
        return personAccounts;
    }
}
