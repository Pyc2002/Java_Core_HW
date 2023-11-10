package HW_3;

public abstract class Employees implements Comparable<Employees> {
    protected String name;


    protected Employees(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new RuntimeException("Имя указано некорректно.");
        }
        this.name = name;
    }

    public abstract double getSalary();

    public enum kindOfEmployee{
        Freelancer, Worker
    }

    public abstract String getInfo();


}