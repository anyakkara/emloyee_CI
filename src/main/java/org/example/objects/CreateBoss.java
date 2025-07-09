package org.example.objects;

import lombok.Getter;
import org.example.models.Boss;

import java.util.ArrayList;

public class CreateBoss {
    @Getter
    private static ArrayList<Boss> bosses = new ArrayList();

    static{
        bosses.add(new Boss(
                "Sergey",
                "Ivanovich",
                "Volkov",
                41,
                "17.05.1983",
                "Zelenaya street 12",
                "Project Manager",
                "Build 4",
                "Project Office",
                "01.11.2015",
                false,
                350000,
                CreateEmployee.getEmployeesSubList(0,1)
        ));

        bosses.add(new Boss(
                "Dmitry",
                "Sergeevich",
                "Morozov",
                29,
                "11.12.1994",
                "Lesnaya street 7",
                "QA Engineer",
                "Build 1",
                "Testing Department",
                "10.02.2021",
                false,
                220000,
                CreateEmployee.getEmployeesSubList(1,4)

        ));
    }
}
