package HW_3;

import java.util.Comparator;

public class EmployeesComparatorBySalary implements Comparator<Employees> {
    /**
     * Компоратор для сравнения сотрудников по заработной плате
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return - результат сравнения
     */
    public int compare(Employees o1, Employees o2) {
        return Integer.compare((int) o2.getSalary(), (int) o1.getSalary());
    }
}
