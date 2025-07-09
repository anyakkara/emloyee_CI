package org.example.models;

import jakarta.xml.bind.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Boss.class, ManagerEmployee.class})

public class Employee extends Person {
    @XmlElement(name = "Position")
    private String position;

    @XmlElement(name = "AddressWork")
    private String addressWork;

    @XmlElement(name = "Department")
    private String department;

    @XmlElement(name = "EmploymentDate")
    private String employmentDate;

    @XmlElement(name = "OnlineWork")
    private boolean onlineWork;

    @XmlElement(name = "Salary")
    private int salary;



    public Employee(String firstName, String lastName, String middleName, int age, String birthDate,
                    String homeAddress, String position, String addressWork, String department,
                    String employmentDate, boolean onlineWork, int salary) {
        super(firstName, middleName,lastName, age, birthDate, homeAddress);
        this.position = position;
        this.addressWork = addressWork;
        this.department = department;
        this.employmentDate = employmentDate;
        this.onlineWork = onlineWork;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("""
                        FullName: %s
                        Age: %d
                        Birth Date: %s
                        Home Address: %s
                        Position: %s
                        Address Work: %s
                        Department: %s
                        Employment Date: %s
                        Online Work: %s
                        Salary: %d
                        """,
                getFullName(), getAge(), getBirthDate(), getHomeAddress(), position, addressWork,
                department, employmentDate, onlineWork ? "Yes" : "No", salary);

    }
}
