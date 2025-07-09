package org.example.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Employee.class})
public class Person {
    @XmlElement(name = "FirstName")
    private String firstName;

    @XmlElement(name = "MiddleName")
    private  String middleName;

    @XmlElement(name = "LastName")
    private  String lastName;

    @XmlElement(name = "Age")
    private  int age;

    @XmlElement(name = "BirthDate")
    private  String birthDate;

    @XmlElement(name = "HomeAddress")
    private  String homeAddress;


    public Person(String firstName, String middleName, String lastName, int age,
                  String birthDate, String homeAddress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.homeAddress = homeAddress;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}
