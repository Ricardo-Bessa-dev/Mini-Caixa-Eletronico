package CashMachineProgram;

import java.util.Scanner;
import CashMachineProgram.bank.Account;
import CashMachineProgram.bank.CashMachine;
import CashMachineProgram.exceptions.OutOfCashExc;
import CashMachineProgram.exceptions.InsuficientBalanceExc;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int op=1;

        while(op!=0) {
            System.out.println("\n--- Cash Machine ---");
            System.out.println("1. Successfull withdraw");
            System.out.println("2. Not enough notes case");
            System.out.println("3. Insuficient balance case");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    withdrawExecution(new CashMachine(3, 3, 3, 3, 3), new Account(800), 250);
                    break;
                case 2:
                    withdrawExecution(new CashMachine(3, 3, 3, 3, 3), new Account(800), 556);
                    break;
                case 3:
                    withdrawExecution(new CashMachine(3, 3, 3, 3, 3), new Account(200), 250);
                    break;
                case 0:
                    System.out.println("Program Closed!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void withdrawExecution(CashMachine machine, Account account, double amount){
        System.out.println("\nYour balance: $" + account.getBalance());
        System.out.println("Trying to withdraw: $" + amount);
        try{
            machine.withdraw(account, amount);
        } catch (InsuficientBalanceExc | OutOfCashExc e) {
            System.out.println(e.getMessage());
            System.out.println("Your balance: $" + account.getBalance());
        }
    }
}
