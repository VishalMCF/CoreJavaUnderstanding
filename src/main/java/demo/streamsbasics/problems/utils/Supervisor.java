package demo.streamsbasics.problems.utils;

import java.util.List;

public class Supervisor {
    private String name;
    private List<Employee> directReports;

    public Supervisor(String name, List<Employee> directReports) {
        this.name = name;
        this.directReports = directReports;
    }

    public String getName() { return name; }
    public List<Employee> getDirectReports() { return directReports; }
}

