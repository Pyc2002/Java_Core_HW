package HW_4;

public class BankOperations {
    public static Account newAccount() {
        while (true) {
            try {
                Account account = Account.createAccount(Account.initialBalance());
                System.out.println(account.getInfo());
               return  account;
            } catch (MyInitialBalanceException e) {
                System.out.printf("%s. Вносимая сумма: [%d]\n", e.getMessage(), e.getAmount());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода данных. Повторите попытку.");
            }
        }
    }
    public static void deposit(Account account){
        while (true) {
            try {
                account.accountDeposit();
                System.out.println(account.getInfo());
                break;
            } catch (MyDepositException e) {
                System.out.printf("%s. Вносимая сумма: [%d]\n", e.getMessage(), e.getAmount());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода данных. Повторите попытку.");
            }
        }

    }

    public static void withdraw(Account account){
        while (true) {
            try {
                account.withdraw();
                System.out.println(account.getInfo());
                break;
            } catch (MyInsufficientFundsException e) {
                System.out.printf("%s. Снимаемая сумма: [%d], баланс счета: [%d]\n", e.getMessage(), e.getWithdraw(), e.getBalance());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода данных. Повторите попытку.");
            }
        }
    }

}
