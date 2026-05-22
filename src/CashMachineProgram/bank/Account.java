package CashMachineProgram.bank;

import CashMachineProgram.exceptions.InsuficientBalanceExc;

public class Account {

    private double balance;

    public Account(double initialBalance){
        this.balance = initialBalance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsuficientBalanceExc{
        if(amount > this.balance){
            throw new InsuficientBalanceExc("Transaction cancelled! You don't have enough balance for a $" + amount + " withdraw.");
        }
        this.balance -= amount;
    }

}
