package HW_4;

public abstract class MyIllegalArgumentException extends Exception {
    private final int amount;

    public int getAmount() {
        return amount;
    }

    public MyIllegalArgumentException(String message, int amount) {
        super(message);
        this.amount = amount;
    }
}
