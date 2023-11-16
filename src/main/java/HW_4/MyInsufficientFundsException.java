package HW_4;

public class MyInsufficientFundsException extends Exception{
    private final int balance;
    private final int withdraw;

    public int getBalance() {
        return balance;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public MyInsufficientFundsException(String message, int balance, int withdraw) {
        super(message);
        this.balance = balance;
        this.withdraw= withdraw;
    }
}
