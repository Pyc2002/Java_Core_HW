package HW_3;

import java.util.Iterator;
import java.util.List;

/**
 * Класс, содержащий методы интерфейса Iterator
 *
 */
public class EmployeeIterator<T> implements Iterator<T> {
    private int index = 0;
    private List<T> employeeList;

    public EmployeeIterator(List<T>employeeList){
        this.employeeList = employeeList;
    }

    public boolean hasNext(){
        return employeeList.size() > index;
    }

    public T next(){
        return employeeList.get(index++);
    }
}
