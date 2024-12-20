package com.example.models;

/* Intended to mirror the structure under com.example.models to test that model classes are working as intended
*/

public class ModelIntegrationTest {
    public static void main(String[] args) {
        PersonRegister register = new PersonRegister();

        Person person1 = new Person("E1", "Emily", 24);
        Person person2 = new Person("E2", "Klas", 34);

        register.addPerson(person1);
        register.addPerson(person2);

        BankAccount account1 = new BankAccount("123", 10000);
        BankAccount account2 = new BankAccount("456", 100);
        BankAccount account3 = new BankAccount("789", 5000);

        person1.addAccount(account1); // Emily 2 accounts
        person1.addAccount(account3);
        account1.setPerson(person1);
        account3.setPerson(person1);

        person2.addAccount(account2);
        account2.setPerson(person2);

        // TESTING
        System.out.println("All names:\n");  
        for (Person person : register.getPersons()) {
            System.out.println(person.getName());
        }
        System.out.println("Person 1's account:");  
        for (BankAccount account : person1.getBankAccounts()) {
            System.out.println(account.getAccountNumber());
            account.deposit(55000);
            System.out.println(account.getBalance());
        }
        System.out.println();

        
        System.out.println("Person 2's balance:");
        for (BankAccount account : person2.getBankAccounts()) {
            System.out.println(account.getBalance());
            account.withdraw(59);
            System.out.println(account.getBalance());
        }
        System.out.println();

        System.out.println("Account 1 holder:");
        System.out.println(account1.getPerson().getName());
        System.out.println();

        System.out.println("Find person 1:");
        System.out.println(register.findPerson("E1").getName());
        System.out.println();


    }

}
