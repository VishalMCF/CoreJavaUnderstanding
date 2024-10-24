package demo.streamsbasics.problems.demo;

import demo.streamsbasics.problems.utils.Department;
import demo.streamsbasics.problems.utils.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        execute_demo_for_flatmap_usage();
    }

    /**
     * get the names of employees who are managers from a list of departments using streams
     */
    public static void execute_demo_for_flatmap_usage(){
        List<Employee> employeeList1 = List.of(
            new Employee("em4", 25, true, 5000),
            new Employee("em5", 22, false, 3000),
            new Employee("em6", 35, true, 7500),
            new Employee("em7", 28, false, 4500),
            new Employee("em8", 40, true, 9000)
        );

        List<Employee> employeeList2 = List.of(
            new Employee("em9", 50, true, 12000),
            new Employee("em10", 30, false, 4000)
        );

        List<Employee> employeeList3 = List.of(
            new Employee("em11", 21, false, 3200),
            new Employee("em12", 32, true, 5500),
            new Employee("em13", 27, false, 3600),
            new Employee("em14", 39, true, 8700),
            new Employee("em15", 25, false, 2800)
        );

        List<Employee> employeeList4 = List.of(
            new Employee("em16", 24, true, 4800),
            new Employee("em17", 38, false, 6800),
            new Employee("em18", 44, true, 9800),
            new Employee("em19", 26, false, 4200),
            new Employee("em20", 29, true, 5900)
        );

        List<Employee> employeeList5 = List.of(
            new Employee("em21", 41, true, 10300),
            new Employee("em22", 34, false, 5700),
            new Employee("em23", 46, true, 12000),
            new Employee("em24", 28, false, 4000),
            new Employee("em25", 31, true, 7300)
        );

        List<Employee> employeeList6 = List.of(new Employee("em1", 10, false, 2000),
            new Employee("em2", 20, false, 1000),
            new Employee("em3", 30, false, 3500));

        Department d1 = new Department("d1", employeeList1);
        Department d2 = new Department("d2", employeeList2);
        Department d3 = new Department("d3", employeeList3);
        Department d4 = new Department("d4", employeeList4);
        Department d5 = new Department("d5", employeeList5);
        Department d6 = new Department("d6", employeeList6);

        List<Department> departmentList = List.of(d1, d2, d3, d4, d5, d6);
        List<String> empNames = departmentList.stream().flatMap(d -> d
            .getEmployees()
            .stream()
            .filter((em) -> em.isManager())
            .map((em) -> em.getName()))
            .collect(Collectors.toList());

        System.out.println(empNames);
    }

}
