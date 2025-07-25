package org.example.models;

import jakarta.xml.bind.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "Boss")
@XmlAccessorType(XmlAccessType.FIELD)
public class Boss extends Employee {

    @XmlElementWrapper(name = "EmployeeWork")
    @XmlElement(name = "Subordinate")
    private ArrayList<SubordinateInfo> subordinates;

    public Boss(String firstName, String middleName, String lastName, int age, String birthDate,
                String homeAddress, String position, String addressWork, String department,
                String employmentDate, boolean onlineWork, int salary, ArrayList<Employee> employees) {
        super(firstName, middleName, lastName, age, birthDate,
                homeAddress, position, addressWork, department, employmentDate, onlineWork, salary);
        this.subordinates = convertEmployeesToSubordinateInfo(employees);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(super.toString());
        info.append("Subordinates:\n");
        for (SubordinateInfo e : subordinates) {
            info.append(e.getFullName()).append("\n");
        }
        return info.toString();
    }

    private ArrayList<SubordinateInfo> convertEmployeesToSubordinateInfo(ArrayList<Employee> employees) {
        ArrayList<SubordinateInfo> result = new ArrayList<>();
        for (Employee e : employees) {
            result.add(new SubordinateInfo(e));
        }
        return result;
    }

    public static ArrayList<SubordinateInfo> getEmployeesSubList(int fromIndex, int toIndex, ArrayList<Employee> employees) {
        ArrayList<SubordinateInfo> result = new ArrayList<>();
        // Создаем новый ArrayList из subList, чтобы избежать проблем с оригинальным списком
        ArrayList<Employee> subList = new ArrayList<>(employees.subList(fromIndex, toIndex));
        for (Employee e : subList) {
            result.add(new SubordinateInfo(e));
        }
        return result;
    }

    @XmlType
    public static class SubordinateInfo {
        @XmlElement(name = "FullName")
        private String fullName;

        public SubordinateInfo() {}

        public SubordinateInfo(Employee employee) {
            this.fullName = employee.getFullName();
        }

        // Геттер можно оставить как есть, так как он помечен @XmlTransient
        @XmlTransient
        public String getFullName() {
            return fullName;
        }
    }
}