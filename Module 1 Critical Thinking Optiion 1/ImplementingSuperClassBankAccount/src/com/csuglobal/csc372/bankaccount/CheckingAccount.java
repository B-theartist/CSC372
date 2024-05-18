package com.csuglobal.csc372.bankaccount;

public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    @Override
    public void withdrawal(double amount) {
        if (getBalance() < amount) {
            super.withdrawal(amount + 30);  
            System.out.println("Overdraft on Account ID: " + getAccountID() + " - $30 fee charged. Current Balance: $" + getBalance());
        } else {
            super.withdrawal(amount);
            System.out.println("Withdrawal from Account ID: " + getAccountID() + " - New Balance: $" + getBalance());
        }
    }

    // Display account details including interest rate
    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}