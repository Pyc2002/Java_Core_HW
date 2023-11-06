package org.example.calculator;

/**
 * Класс Calculation производит четыре основных математических действия,
 * использует оператор switch.
 */

public class Calculation {

    /**
     * Функция суммирования двух целых чисел
     *
     * @param firstOperand первое целое число
     * @param secondOperand второе целое число
     * @param operator математическое действие ("+", "-", "*", "/")
     * @return вывод результата математического действия чисел firstOperand и secondOperand.
     */
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Деление на 0 невозможно");
                }
            default:
                throw new IllegalStateException("Невалидный символ: " + operator);
        }
        return result;
    }
}
