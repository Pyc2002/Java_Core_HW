package HW_3;

import java.util.Comparator;

public class EmployeesComparatorByName implements Comparator<Employees> {
    /**
     * Компоратор для сравнения сотрудников по имени
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return - результат сравнения
     */
    public int compare(Employees o1, Employees o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
