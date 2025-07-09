package org.example.models;
import lombok.Getter;
import lombok.Setter;
import jakarta.xml.bind.annotation.*;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "ManagerEmployee")
@XmlAccessorType(XmlAccessType.FIELD)

public class ManagerEmployee extends Employee {
    @XmlElementWrapper(name = "Clients")
    @XmlElement(name = "Client")
    private ArrayList<Organization> organizations;

    public ManagerEmployee(String firstName, String lastName, String middleName, int age, String birthDate,
                           String homeAddress, String position, String addressWork, String department,
                           String employmentDate, boolean onlineWork, int salary,ArrayList<Organization> organizations){
        super(firstName, lastName, middleName, age, birthDate, homeAddress,
                position, addressWork, department, employmentDate, onlineWork, salary);
        this.organizations = organizations;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Clients:\n");
        for(Organization o : organizations){
            sb.append(o.getName()).append("\n");
        }
        return sb.toString();
    }



}
