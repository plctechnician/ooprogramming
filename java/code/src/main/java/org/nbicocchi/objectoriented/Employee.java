package org.nbicocchi.objectoriented;

/**
 * Create a class Employee including three private instance variables:
 * firstName (String)
 * lastName (String)
 * salary (double).
 * <p>
 * The class must have a constructor for initializing all three attributes.
 * The salary cannot be lower that a default threshold taken from a static variable.
 *
 * The class must have a second constructor setting only first name
 * and last name. In this case, salary must be set to a default value taken from a static variable.
 * <p>
 * Write a test application demonstrating the class Employee’s capabilities.
 * <p>
 * Remember! Getters, Setters, Constructors and toString methods can be
 * automatically created with Eclipse (see Source Menu).
 *
 * @author Nicola Bicocchi
 */

public class Employee {
    public static final double minimumSalary = 1000;
    public static final double defaultSalary = 2000;

    String name;
    String lastname;
    double salary;

    public Employee(String name, String lastname, double salary) {
        this.name = name;
        this.lastname = lastname;
        this.salary = Math.max(minimumSalary, salary);
    }

    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.salary = defaultSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Mario", "Rossi", 3000.0);
        Employee e2 = new Employee("Luca", "Bianchi", 800);

        System.out.println(e1);
        System.out.println(e2);

        e1.setSalary(e1.getSalary() * 1.5);
        e2.setSalary(e2.getSalary() * 1.5);

        System.out.println(e1);
        System.out.println(e2);
    }
}