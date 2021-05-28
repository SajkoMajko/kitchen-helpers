package com.codecool.kitchenmanagement;

import java.time.LocalDate;

public abstract class Employee {
    public Employee(String name, LocalDate birthDate, int salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getSalary() {
        return salary;
    }

    private String name;
    private java.time.LocalDate birthDate;
    private int salary;

    public void printTax() {
        int tax = (int) (salary * 0.99);
    }


    @Override
    public String toString(){
        return String.format("Employee's name is %s", name);
    }
}
