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
@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "Subordinate")
public class EmployeeShort extends Person{
    @XmlElement(name = "FullName")
    @Override
    public String getFullName(){
        return super.getFullName();
    }
}
