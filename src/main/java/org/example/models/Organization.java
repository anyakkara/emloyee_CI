package org.example.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import jakarta.xml.bind.annotation.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)

public class Organization {
    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Address")
    private String address;

    @XmlElement(name = "ContactPerson")
    private String contactPerson;

    @XmlElement(name = "ContactPhone")
    private String contactPhone;

    public  Organization(String name, String address, String contactPerson, String contactPhone) {
        this.name = name;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return String.format("Organization: %s\nAddress: %s\nContact Person: %s\nContact Phone:",
                name, address, contactPerson, contactPhone);
    }


}
