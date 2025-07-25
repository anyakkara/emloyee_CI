package org.example.objects;

import lombok.Getter;
import org.example.models.Employee;

import java.util.ArrayList;


public class CreateEmployee {
    @Getter
    private static final ArrayList<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(
                "Ivan",
                "Ivanovich",
                "Ivanov",
                45,
                "10.03.1980",
                "Ivanovskya street 123",
                "Analyst",
                "Build 2",
                "Department IT",
                "01.03.2020",
                false,
                300000));

        employees.add(new Employee(
                "Elena",
                "Petrovna",
                "Smirnova",
                38,
                "22.06.1986",
                "Pushkina street 45",
                "System Administrator",
                "Build 1",
                "Department IT",
                "15.04.2018",
                true,
                250000));

        employees.add(new Employee(
                "Dmitry",
                "Sergeevich",
                "Kuznetsov",
                29,
                "11.12.1995",
                "Lenina street 10",
                "Backend Developer",
                "Build 3",
                "Department Development",
                "10.02.2022",
                false,
                280000));

        employees.add(new Employee(
                "Olga",
                "Nikolaevna",
                "Morozova",
                33,
                "30.09.1991",
                "Sovetskaya street 78",
                "HR Specialist",
                "Build 5",
                "Human Resources",
                "20.06.2019",
                true,
                220000));
    }

    public static ArrayList<Employee> getEmployeesSubList(int fromIndex, int toIndex) {
        return new ArrayList<>(employees.subList(fromIndex, toIndex));
    }

}