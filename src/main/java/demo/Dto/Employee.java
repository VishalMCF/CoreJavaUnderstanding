package org.embibe.demo.Dto;

import java.io.*;

public class Employee extends Person implements Serializable, Cloneable  {

    private Address address;

    private String employeeId;

    public Employee(String firstName, String lastName, String phone) {
        super(firstName, lastName, phone);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employee() {
        super();
    }

    @Override
    public Employee clone() {
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return (Employee) super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
            "address=" + address +
            ", employeeId='" + employeeId + '\'' +
            ", firstName ='" + super.getFirstName() + '\'' +
            ", secondName ='" + super.getLastName() + '\'' +
            ", phone ='" + super.getPhone() + '\'' +
            '}';
    }
}
