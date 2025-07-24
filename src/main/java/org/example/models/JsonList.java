package org.example.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Getter
public class JsonList {
    public static <T> void jsonEmloyee(ArrayList<T> list, String fname){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<T> emp = list;
        try (FileWriter writer = new FileWriter(fname)) {
            gson.toJson(emp, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
