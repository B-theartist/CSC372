package com.csuglobal.csc372.bankaccount;


public class BankAccountTester {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount myAccount = new BankAccount("Joe", "Mixon", 123456);
        myAccount.deposit(1000);
        myAccount.withdrawal(200);
        myAccount.accountSummary();

        // Create a CheckingAccount object
        CheckingAccount myCheckingAccount = new CheckingAccount("Emily", "Blunt", 654321, 0.5);
        myCheckingAccount.deposit(1500);
        myCheckingAccount.withdrawal(1600); // This will trigger the overdraft
        myCheckingAccount.displayAccount();
    }
}
