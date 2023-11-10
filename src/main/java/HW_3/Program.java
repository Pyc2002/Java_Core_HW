package HW_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        ListOfEmployees list = new ListOfEmployees();
        list.addEmployee(Freelancer.createFreelancer("Иван", 1000));
        list.addEmployee(Freelancer.createFreelancer("Василий", 1500));
        list.addEmployee(Worker.createWorker("Дмитрий", 80000));
        list.addEmployee(Worker.createWorker("Олег", 100000));

        for (Employees item: list) {
            System.out.println(item.getInfo());
        }
        System.out.println();

        list.sortByName();
        for (Employees item: list) {
            System.out.println(item.getInfo());
        }

        System.out.println();
        list.sortBySalary();
        for (Employees item: list) {
            System.out.println(item.getInfo());
        }
    }
}