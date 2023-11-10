package HW_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Класс ListOfEmployees содержит коллекцию сотрудников
 *
 */

public class ListOfEmployees implements Iterable<Employees>{
    private List<Employees> employeesList;

    public ListOfEmployees() {
        employeesList = new ArrayList<>();
    }

    /**
     * Метод добавления работника в коллекцию
     * @param employee - создается новый сотрудник
     */
    public void addEmployee(Employees employee){
        employeesList.add(employee);
    }

    /**
     * Сортировка коллекции по имени сотрудника
     */
    public void sortByName() {
        employeesList.sort(new EmployeesComparatorByName());
    }
    /**
     * Сортировка коллекции по заработной плате сотрудника
     */
    public void sortBySalary() {
        employeesList.sort(new EmployeesComparatorBySalary());
    }

    /**
     * Метод, использующий свой Iterator EmployeeIterator
     * @return - возвращает инициализированный компоратор EmployeeIterator для колликции работников
     */
    @Override
    public Iterator<Employees> iterator() {
        return new EmployeeIterator<>(employeesList);
    }
}
