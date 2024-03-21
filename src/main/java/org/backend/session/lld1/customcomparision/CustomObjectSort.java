package org.backend.session.lld1.customcomparision;


import java.util.Arrays;

class Employee implements Comparable<Employee>{
    String name;
    int age;
    int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {

        if( this.age == employee.age ) return this.salary - employee.salary;
        return this.age - employee.age;
    }
}
public class CustomObjectSort {

    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee("Rohan", 45, 80000);
        employees[1] = new Employee("Sham", 45, 90000);
        employees[2] = new Employee("Aryan", 36, 80000);
        employees[3] = new Employee("Akanksha", 24, 80000);

        Arrays.sort(employees);
        System.out.println("After sorting -> " + Arrays.toString(employees));

    }
}
