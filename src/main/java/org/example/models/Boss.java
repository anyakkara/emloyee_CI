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

public class Boss extends Employee{
    @XmlElementWrapper(name = "EmployeeWork")
    @XmlElement(name = "Subordinate")
    private ArrayList<EmployeeShort> employees;

    public Boss(String firstName,String middleName, String lastName,  int age, String birthDate,
                String homeAddress, String position, String addressWork, String department,
                String employmentDate, boolean onlineWork, int salary, ArrayList<EmployeeShort> employees){
        super(firstName,middleName, lastName, age, birthDate,
                homeAddress, position, addressWork, department, employmentDate, onlineWork, salary);
        this.employees = employees;

    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder(super.toString());
        info.append("Employee Name:\n");
        for (EmployeeShort e: employees){
            info.append(e.getFullName()+"\n");
        }

        return info.toString();
    }

}
