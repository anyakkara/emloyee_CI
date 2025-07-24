package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.models.*;
import org.example.objects.CreateBoss;
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
        ArrayList<Boss> bossList= CreateBoss.getBosses();

        try{
            StringBuilder bossBuilder = new StringBuilder();
            for (Boss b : bossList) {
                bossBuilder.append(b.toString()).append("\n");
            }
            writeToFile("bosses.txt",bossBuilder.toString());

            StringBuilder employeeBulder = new StringBuilder();
            for (Employee e : employeeList) {
                employeeBulder.append(e.toString()).append("\n");
            }
            writeToFile("employees.txt",employeeBulder.toString());

            StringBuilder managerBulder = new StringBuilder();
            for (Employee e : managerList) {
                managerBulder.append(e.toString()).append("\n");
            }
            writeToFile("managers.txt",managerBulder.toString());

        } catch (IOException e){
            System.err.println("Ошибка при записи: " + e.getMessage());
        }


        writeToXml(employeeList,"employee.xml", Employee.class);
        writeToXml(bossList,"bosses.xml", Boss.class);
        writeToXml(managerList,"managers.xml", ManagerEmployee.class);

        JsonList.jsonEmloyee(employeeList,"employee.json");
        JsonList.jsonEmloyee(bossList,"bosses.json");
        JsonList.jsonEmloyee(managerList,"managers.json");
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