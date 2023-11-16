package HW_4;

public class MyDepositException extends MyIllegalArgumentException{
    public MyDepositException(String message, int balance){
        super(message, balance);
    }
}
