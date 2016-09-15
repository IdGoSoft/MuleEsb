package com.idgoSoft.trade.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
	Map<Gender, Map<Object, String>> personsByGenderAndDobMonth = Employee.persons().stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.groupingBy(p -> p.getDob().getMonth(),
			Collectors.mapping(Employee::getName, Collectors.joining(", ")))));

	System.out.println(personsByGenderAndDobMonth);
    }
}

enum Gender {
    MALE, FEMALE
}

class Employee {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    public Employee(long id, String name, Gender gender, LocalDate dob, double income) {
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.dob = dob;
	this.income = income;
    }

    public String getName() {
	return name;
    }

    public Gender getGender() {
	return gender;
    }

    public LocalDate getDob() {
	return dob;
    }

    public static List<Employee> persons() {
	Employee ken = new Employee(1, "Jame", Gender.MALE, LocalDate.of(1970, Month.MAY, 4), 6123.0);
	Employee jeff = new Employee(2, "Jeff", Gender.MALE, LocalDate.of(1971, Month.JULY, 5), 7112.0);
	Employee donna = new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1972, Month.JULY, 9), 8712.0);
	Employee chris = new Employee(4, "Jodd", Gender.MALE, LocalDate.of(1973, Month.DECEMBER, 6), 1823.0);
	Employee laynie = new Employee(5, "Janey", Gender.FEMALE, LocalDate.of(1974, Month.DECEMBER, 3), 1234.0);
	Employee lee = new Employee(6, "Jason", Gender.MALE, LocalDate.of(1975, Month.MAY, 8), 2412.0);

	// Create a list of persons
	List<Employee> persons = Arrays.asList(ken, jeff, donna, chris, laynie, lee);

	return persons;
    }
}