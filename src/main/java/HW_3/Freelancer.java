package HW_3;

public class Freelancer extends Employees implements Comparable<Employees>{
    private double hourlyRate;
    private kindOfEmployee kindOfEmployee;

    private Freelancer(String name, double hourlyRate) {
        super(name);
                this.hourlyRate = hourlyRate;
        this.kindOfEmployee = Employees.kindOfEmployee.Freelancer;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getName() {
        return name;
    }

    /**
     * Фабричный метод для создания объекта Freelancer
     * @param name Имя
     * @param hourlyRate Почасовая ставка
     * @return объект Freelancer
     * @throws RuntimeException Некорректное имя или почасовая ставка
     */
    public static Freelancer createFreelancer(String name, int hourlyRate) throws RuntimeException{
        if (name == null){
            throw new RuntimeException("Имя не указано.");
        }
        if (hourlyRate <= 0){
            throw new RuntimeException("Почасовая ставка указана некорректно.");
        }

        return new Freelancer(name, hourlyRate);
    }

    @Override
    public double getSalary() {
        return 20.8*8*hourlyRate;
    }

    @Override
    public String getInfo() {
        String stringFreelancer = "Имя: " + name +
                ", работник: " + kindOfEmployee +
                ", почастовая ставка: " + getHourlyRate() +
                ", среднемесячная з/п: " + getSalary();

        return stringFreelancer;
    }

    @Override
    public int compareTo(Employees o) {
        return name.compareTo(o.name);
    }
}
