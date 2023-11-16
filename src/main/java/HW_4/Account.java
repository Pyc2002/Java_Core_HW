package HW_4;

import java.util.Scanner;



public class Account {
    private static final Scanner scanner = new Scanner(System.in);

    private static int accountBalance;
    private static int initialAmount;

    private Account(int initialSum) {
        this.initialAmount = initialSum;
    }

    public static Account createAccount(int initSum){
        if (initSum == 0){
            throw new RuntimeException("Сумма не указана.");
        }
        return new Account(initialAmount);
    }


    public static int initialBalance() throws MyInitialBalanceException{
        System.out.print("Введите начальный баланс счета: ");
        int balance =Integer.parseInt(scanner.nextLine());
        if (balance < 0){
            throw new MyInitialBalanceException("Попытка создать счет с отрицательным начальным балансом", balance);
        }
        return accountBalance += balance;

    }

    public void accountDeposit() throws MyDepositException{
        System.out.print("Введите сумму депозита: ");
        int deposit =Integer.parseInt(scanner.nextLine());
        if (deposit < 0)
            throw new MyDepositException("Попытка внести депозит с отрицательной суммой", deposit);
        accountBalance += deposit;
    }

    public void withdraw() throws MyInsufficientFundsException{
        System.out.print("Введите сумму снятия средств: ");
        int cash =Integer.parseInt(scanner.nextLine());
        if (accountBalance < cash)
            throw new MyInsufficientFundsException("Попытка снять средства, сумма которых превышает текущий баланс", accountBalance, cash);
        accountBalance -= cash;
    }

    public String getInfo() {

        return "Баланс счета: " + accountBalance;
    }

}
