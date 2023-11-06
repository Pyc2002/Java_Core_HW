package org.example.calculator;

/**
 * Класс View осуществляет форматированный
 * вывод результатов пользователю в консоль.
 */
public class View {
    /**
     * @param res число, полученное в результате вычисления
     * @return строка с результатом.
     */
    public static void viewResult(int res) {
        System.out.println(" ");
        System.out.println("Результат вычисения: "+ res);
    }
}
