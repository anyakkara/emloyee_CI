package org.example.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvList {
    public static void csvEmployee(String fname, ArrayList<Employee> employees) throws IOException {
        try (FileWriter fw = new FileWriter(fname)){
            fw.write("Full Name, Age, Birth Date, Home Address, Position, " +
                    "Address Work, Department, Employment Date, Online Work, Salary, \n");

            for(Employee e : employees){
                fw.write(String.format("%s,%d,%s,%s,%s,%s,%s,%s,%s,%d\n",
                        e.getFullName(),
                        e.getAge(),
                        e.getBirthDate(),
                        e.getHomeAddress(),
                        e.getPosition(),
                        e.getAddressWork(),
                        e.getDepartment(),
                        e.getEmploymentDate(),
                        e.isOnlineWork(),
                        e.getSalary()));
            }
        }

    }

    public static void csvBoss(String fname, ArrayList<Boss> bosses) throws IOException {
        try (FileWriter fw = new FileWriter(fname)){
            fw.write("Full Name, Age, Birth Date, Home Address, Position, " +
                    "Address Work, Department, Employment Date, Online Work, Salary, Subordinates, \n");

            for (Boss boss : bosses) {
                StringBuilder subordinates = new StringBuilder();
                for (Boss.SubordinateInfo sub : boss.getSubordinates()) {
                    if (subordinates.length() > 0) {
                        subordinates.append("; ");
                    }
                    subordinates.append(sub.getFullName());
                }

                fw.write(String.format("%s,%d,%s,%s,%s,%s,%s,%s,%b,%d,\"%s\"\n",
                        boss.getFullName(),
                        boss.getAge(),
                        boss.getBirthDate(),
                        boss.getHomeAddress(),
                        boss.getPosition(),
                        boss.getAddressWork(),
                        boss.getDepartment(),
                        boss.getEmploymentDate(),
                        boss.isOnlineWork(),
                        boss.getSalary(),
                        subordinates));
            }
        }
    }


}
