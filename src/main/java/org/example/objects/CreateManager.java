package org.example.objects;

import lombok.Getter;
import org.example.models.ManagerEmployee;
import org.example.models.Organization;

import java.util.ArrayList;

public class CreateManager {
    @Getter
    private static ArrayList<ManagerEmployee> managers = new ArrayList();

    static{
        managers.add(new ManagerEmployee(
                "John",
                "Doe",
                "Michael",
                35, "15.06.1989",
                "42 Main St",
                "Client Manager",
                "Building A",
                "Sales",
                "10.01.2018",
                true,
                80000,
                CreateOrganization.getOrganizationsSubList(0,1)
        ));

        managers.add(new ManagerEmployee(
                "Emily",
                "Clark",
                "Jane",
                29,
                "22.03.1995",
                "78 Elm St",
                "Client Manager",
                "Building B",
                "Support",
                "01.09.2020",
                false,
                100000,
                CreateOrganization.getOrganizationsSubList(0,2)
        ));

        managers.add(new ManagerEmployee(
                "David",
                "Brown",
                "Lee",
                40,
                "02.12.1984",
                "96 Oak St",
                "Senior Client Manager",
                "Headquarters",
                "Corporate Sales",
                "20.05.2021",
                true,
                85000,
                CreateOrganization.getOrganizationsSubList(0,1)

        ));
    }

}
