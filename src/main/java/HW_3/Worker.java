package HW_3;

public class Worker extends Employees implements Comparable<Employees>{
    private double monthlyRate;
    private kindOfEmployee kindOfEmployee;

    private Worker(String name, double monthlyRate) {
        super(name);
        this.monthlyRate = monthlyRate;
        this.kindOfEmployee = Employees.kindOfEmployee.Worker;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public String getName() {
        return name;
    }

    /**
     * Фабричный метод для создания объекта Worker
     * @param name Имя
     * @param monthlyRate Фиксированная месячная оплата
     * @return объект Worker
     * @throws RuntimeException Некорректное имя или фиксированная месячная оплата
     */
    public static Worker createWorker(String name, int monthlyRate) throws RuntimeException{
        if (name == null){
            throw new RuntimeException("Имя не указано");
        }
        if (monthlyRate <= 0){
            throw new RuntimeException("Фиксированная месячная оплата указана некорректно.");
        }

        return new Worker(name, monthlyRate);
    }

    @Override
    public double getSalary() {
        return monthlyRate;
    }

    @Override
    public String getInfo() {
        String stringWorker = "Имя: " + name +
                ", работник: " + kindOfEmployee +
                ", среднемесячная з/п: " + getSalary();

        return stringWorker;
    }
    @Override
    public int compareTo(Employees o) {
        return name.compareTo(o.name);
    }


}

