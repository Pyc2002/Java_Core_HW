package org.example.main;

import org.example.calculator.Calculation;
import org.example.calculator.View;
/**
 * Основной класс, запускает приложение, позволяющее
 * производить четыре основных математических действия и
 * осуществлять форматированный
 * вывод результатов пользователю
 */
public class Main {
    /**
     * Точка входа
     */
    public static void main(String[] args) {
        View.viewResult(Calculation.calculation(5,5,'+'));
        View.viewResult(Calculation.calculation(5,5,'-'));
        View.viewResult(Calculation.calculation(5,5,'*'));
        View.viewResult(Calculation.calculation(5,5,'/'));
    }
}