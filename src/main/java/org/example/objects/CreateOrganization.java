package org.example.objects;

import lombok.Getter;
import org.example.models.Organization;

import java.util.ArrayList;

public class CreateOrganization {
    @Getter
    private static final ArrayList<Organization> organizations = new ArrayList<>();

    static {
        organizations.add(new Organization(
                "Romashka LLC",
                "1 Tsvetochnaya Street",
                "Ivanov I.I.",
                "+79991112233"
        ));

        organizations.add(new Organization(
                "Orkhideya JSC",
                "12 Polevaya Street",
                "Petrov P.P.",
                "+79992223344"
        ));
    }

    public static ArrayList<Organization> getOrganizationsSubList(int fromIndex, int toIndex) {
        return new ArrayList<>(organizations.subList(fromIndex, toIndex));
    }
}
