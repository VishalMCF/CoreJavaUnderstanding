package org.embibe.demo.serializable;

import java.io.*;
import java.util.*;
import org.embibe.demo.Dto.*;

/**
 * Important points regarding serialization interface:- 1) It is a marker interface which is used by the compiler to mark a class serializable 2) If a
 * class implements this interface and it also extends a class then the superclass does not need to implement serializable 3) If there is an instance
 * which is a custom class composed of further custom objects then all those objects classes must also implement serializable, or they need to be
 * marked as transient
 * Dusring deserialization No argumnent constructor must be present in the class.
 */

public class SerializableDemo {

    public static void main(String[] args) {
        execute_demo_write_object_to_file_after_serialization();
        execute_demo_read_object_to_file_after_serialization();
    }

    public static void execute_demo_write_object_to_file_after_serialization() {
        System.out.println("Serializable Demo");
        Employee emp1 = new Employee("first", "last", "888888888");
        Address address = new Address("Bengaluru", "Karnataka", "India");
        emp1.setAddress(address);

        Employee emp2 = emp1.clone();
        Employee emp3 = emp1.clone();

        List<Employee> employeeList = new ArrayList<>(List.of(emp1, emp2, emp3));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.dat"))) {
            oos.writeObject(employeeList);
            System.out.println("Custom object successfully serialized");
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void execute_demo_read_object_to_file_after_serialization() {
        System.out.println("De-Serializable Demo");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.dat"))) {
            Object readObject = ois.readObject();
            List<Employee> employeeList = (List<Employee>) readObject;
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
            System.out.println("Custom object successfully de-serialized");
        } catch (IOException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
    }

}
