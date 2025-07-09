package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        Organization org1 = new Organization(
                "ООО Ромашка",
                "ул. Цветочная 1",
                "Иванов И.И.",
                "+79991112233");
        Organization org2 = new Organization(
                "ЗАО Орхидея",
                "ул. Полевая 12",
                "Петров П.П.",
                "+79992223344");

        ArrayList<Organization> clientList_1 = new ArrayList<>();
        clientList_1.add(org1);

        ArrayList<Organization> clientList_2 = new ArrayList<>();
        clientList_2.add(org1);
        clientList_2.add(org2);


        Employee emp1 = new Employee(
                "Ivan",
                "Ivanovich",
                "Ivanov",
                45,
                "10.03.1980",
                "Ivanovskya street 123",
                "Analyst",
                "Build 2",
                "Department IT",
                "01.03.2020",
                false,
                300000);


        Employee emp2 = new Employee(
                "Elena",
                "Petrovna",
                "Smirnova",
                38,
                "22.06.1986",
                "Pushkina street 45",
                "System Administrator",
                "Build 1",
                "Department IT",
                "15.04.2018",
                true,
                250000);


        Employee emp3 = new Employee(
                "Dmitry",
                "Sergeevich",
                "Kuznetsov",
                29,
                "11.12.1995",
                "Lenina street 10",
                "Backend Developer",
                "Build 3",
                "Department Development",
                "10.02.2022",
                false,
                280000);


        Employee emp4 = new Employee(
                "Olga",
                "Nikolaevna",
                "Morozova",
                33,
                "30.09.1991",
                "Sovetskaya street 78",
                "HR Specialist",
                "Build 5",
                "Human Resources",
                "20.06.2019",
                true,
                220000);

        ArrayList<Employee> emp_list= new ArrayList<>();
        emp_list.add(emp1);
        emp_list.add(emp2);
        emp_list.add(emp3);
        emp_list.add(emp4);

        Boss boss = new Boss(
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
                emp_list);

        ArrayList<Boss> boss_list= new ArrayList<>();
        boss_list.add(boss);


        ManagerEmployee manager1 = new ManagerEmployee(
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
                clientList_1);

        ManagerEmployee manager2 = new ManagerEmployee(
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
                clientList_2);

        ManagerEmployee manager3 = new ManagerEmployee(
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
                clientList_1);

        ArrayList<ManagerEmployee> manager_list= new ArrayList<>();
        manager_list.add(manager1);
        manager_list.add(manager2);
        manager_list.add(manager3);



        try{
            writeToFile("bosses.txt",boss.toString());

            StringBuilder emp = new StringBuilder();
            for (Employee e : emp_list) {
                emp.append(e.toString()).append("\n");
            }
            writeToFile("employees.txt",emp.toString());

            StringBuilder m_emp = new StringBuilder();
            for (Employee e : manager_list) {
                m_emp.append(e.toString()).append("\n");
            }
            writeToFile("managers.txt",m_emp.toString());

        } catch (IOException e){
            System.err.println("Ошибка при записи: " + e.getMessage());
        }


        writeToXml(emp_list,"employee.xml", Employee.class);
        writeToXml(boss_list,"bosses.xml", Boss.class);
        writeToXml(manager_list,"managers.xml", ManagerEmployee.class);


        for (Boss b : boss_list) {
            b.setEmployees(new ArrayList<>());
        }

        for (ManagerEmployee e : manager_list) {
            e.setOrganizations(new ArrayList<>());
        }


        ArrayList<Employee> all_employee_list = (ArrayList<Employee>) Stream.concat
                        (Stream.concat(emp_list.stream(), boss_list.stream()), manager_list.stream())
                .collect(Collectors.toList());

        writeToXml(all_employee_list,"all_employee.xml", Employee.class);

    }

    public static void writeToFile(String fname,String content) throws IOException{
        try(FileWriter writer = new FileWriter(fname)){
            writer.write(content);
        }
    }

    public static <T> void writeToXml(ArrayList<T> list, String filePath, Class<T> itemClass) throws Exception {
        XmlList<T> wrapper = new XmlList<>(list);
        JAXBContext context = JAXBContext.newInstance(XmlList.class, itemClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(wrapper, new FileWriter(filePath));
    }

}