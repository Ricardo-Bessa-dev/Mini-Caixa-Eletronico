package CashMachineProgram.bank;

import CashMachineProgram.exceptions.InsuficientBalanceExc;
import CashMachineProgram.exceptions.OutOfCashExc;

public class CashMachine {

    private int qtNotes100; //Quantity of each note (bill)
    private int qtNotes50;
    private int qtNotes20;
    private int qtNotes10;
    private int qtNotes05;

    public CashMachine(int notes100, int notes50, int notes20, int notes10, int notes05){ //Constructor
        this.qtNotes100 = notes100;
        this.qtNotes50 = notes50;
        this.qtNotes20 = notes20;
        this.qtNotes10 = notes10;
        this.qtNotes05 = notes05;
    }

    public void withdraw(Account account, double requestedAmount) throws InsuficientBalanceExc, OutOfCashExc{

        account.withdraw(requestedAmount); //Consult if the withdraw is bigger than the balance

        double opAmount = requestedAmount; //Operational amount to check the feasibility of the transaction



        int opNotes100 = qtNotes100; //Operational Notes quantity variables to check the feasibility of the transaction
        int opNotes50 = qtNotes50;
        int opNotes20 = qtNotes20;
        int opNotes10 = qtNotes10;
        int opNotes05 = qtNotes05;

        while(opAmount >= 100 && opNotes100 >0){
            opAmount -= 100;
            opNotes100--;
        }
        while(opAmount >= 50 && opNotes50 >0){
            opAmount -= 50;
            opNotes50--;
        }
        while(opAmount >= 20 && opNotes20 >0){
            opAmount -= 20;
            opNotes20--;
        }
        while(opAmount >= 10 && opNotes10 >0){
            opAmount -= 10;
            opNotes10--;
        }
        while(opAmount >= 5 && opNotes05 >0){
            opAmount -= 5;
            opNotes05--;
        }

        if(opAmount>0){
            account.deposit(requestedAmount);
            throw new OutOfCashExc("Transaction cancelled! Sorry, the Cash Machine doesn't have enough notes." + "\nAmount missing: $" +opAmount +"\nThe amount did NOT leave your account.");
        }

        qtNotes100 = opNotes100;
        qtNotes50 = opNotes50;
        qtNotes20 = opNotes20;
        qtNotes10 = opNotes10;
        qtNotes05 = opNotes05;

        System.out.println("Transaction completed! \nYour balance: $" + account.getBalance());
    }
}
