package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.models.*;
import org.example.objects.CreateEmployee;
import org.example.objects.CreateManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<ManagerEmployee> managerList = CreateManager.getManagers();
        ArrayList<Employee> employeeList = CreateEmployee.getEmployees();


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
                employeeList);

        ArrayList<Boss> boss_list= new ArrayList<>();
        boss_list.add(boss);





        try{
            writeToFile("bosses.txt",boss.toString());

            StringBuilder emp = new StringBuilder();
            for (Employee e : employeeList) {
                emp.append(e.toString()).append("\n");
            }
            writeToFile("employees.txt",emp.toString());

            StringBuilder m_emp = new StringBuilder();
            for (Employee e : managerList) {
                m_emp.append(e.toString()).append("\n");
            }
            writeToFile("managers.txt",m_emp.toString());

        } catch (IOException e){
            System.err.println("Ошибка при записи: " + e.getMessage());
        }


        writeToXml(employeeList,"employee.xml", Employee.class);
        writeToXml(boss_list,"bosses.xml", Boss.class);
        writeToXml(managerList,"managers.xml", ManagerEmployee.class);


        for (Boss b : boss_list) {
            b.setEmployees(new ArrayList<>());
        }

        for (ManagerEmployee e : managerList) {
            e.setOrganizations(new ArrayList<>());
        }




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