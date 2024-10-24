package demo.streamsbasics.problems.utils;

import java.util.Optional;

public class Employee {
    private String name;
    private int age;
    private boolean isManager;
    private int salary;
    private Optional<Supervisor> supervisor;
    private int bonus;

    public Employee(String name, int age, boolean isManager, int salary) {
        this.name = name;
        this.age = age;
        this.isManager = isManager;
        this.salary = salary;
        this.supervisor = Optional.empty();
        this.bonus = (int)(salary * 0.1);
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isManager() { return isManager; }
    public int getSalary() { return salary; }
    public int getBonus() { return bonus; }
    public Optional<Supervisor> getSupervisor() { return supervisor; }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = Optional.of(supervisor);
    }
}
