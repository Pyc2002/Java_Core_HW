package HW_4;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Account account = BankOperations.newAccount();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите 1 для пополнения счета, 2 для снятия со счета, 3 - выход:");
            int choice = scanner.nextInt();
            if (choice == 1) {
                BankOperations.deposit(account);
            } else if (choice == 2) {
                BankOperations.withdraw(account);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Неверный ввод");
            }
        } while (true);

    }
}
