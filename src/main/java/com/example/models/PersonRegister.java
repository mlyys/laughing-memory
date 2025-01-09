package com.example.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonRegister {
    private ObservableList<Person> persons;
    private ObservableList<BankAccount> bankAccounts;

    public PersonRegister() {
        this.persons = FXCollections.observableArrayList();
        this.bankAccounts = FXCollections.observableArrayList();
        addTestData();
    }

    public ObservableList<Person> getPersons() {
        // return this.persons; // FOR TESTING
        return FXCollections.unmodifiableObservableList(this.persons);
    }

    public ObservableList<BankAccount> getBankAccounts() {
        // return this.bankAccounts; // FOR TESTING
        return FXCollections.unmodifiableObservableList(this.bankAccounts);
    }

    public void removeAccount(BankAccount account) {
        bankAccounts.remove(account);
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
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
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
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

    /*
     * public ObservableList<PersonAccount> getPersonAccounts() {
     * ObservableList<PersonAccount> personAccounts =
     * FXCollections.observableArrayList();
     * for (Person person : persons) {
     * for (BankAccount account : person.getBankAccounts()) {
     * personAccounts.add(new PersonAccount(
     * person, account));
     * }
     * }
     * return personAccounts;
     * }
     */

    private void addTestData() {
        Person person1 = new Person("9405260002", "Anna", 31);
        BankAccount account1 = new BankAccount("12345", 5000.0);
        BankAccount account2 = new BankAccount("67890", 10000.0);
        account1.setPerson(person1); // Set the owner
        account2.setPerson(person1);
        person1.addAccount(account1); // Associate accounts with the person
        person1.addAccount(account2);

        Person person2 = new Person("7801031133", "John", 47);
        BankAccount account3 = new BankAccount("54321", 7000.0);
        person2.addAccount(account3);
        account3.setPerson(person2);

        Person person3 = new Person("0309123478", "Nelly", 22);
        BankAccount account4 = new BankAccount("81938", 500.0);
        person3.addAccount(account4);
        account4.setPerson(person3);

        // Bank accounts without owners
        BankAccount account5 = new BankAccount("11000", 500000.0);
        BankAccount account6 = new BankAccount("22000", 10000.0);
        BankAccount account7 = new BankAccount("33000", 2500.0);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        bankAccounts.add(account1);
        bankAccounts.add(account2);
        bankAccounts.add(account3);
        bankAccounts.add(account4);
        bankAccounts.add(account5);
        bankAccounts.add(account6);
        bankAccounts.add(account7);

    }

    /*
     * public ArrayList<Person> getPersons() {
     * return persons;
     * }
     * 
     * public void setPersons(ArrayList<Person> persons) {
     * this.persons = persons;
     * }
     * 
     * public ArrayList<BankAccount> getBankAccounts() {
     * return bankAccounts;
     * }
     * 
     * 
     * public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
     * this.bankAccounts = bankAccounts;
     * }
     */
}
