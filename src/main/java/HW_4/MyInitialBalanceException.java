package HW_4;

public class MyInitialBalanceException extends MyIllegalArgumentException{
    public MyInitialBalanceException(String message, int balance){
        super(message, balance);
    }
}
