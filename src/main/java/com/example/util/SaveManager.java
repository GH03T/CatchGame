package com.example.util;

import com.google.gson.Gson;
import java.io.*;

import com.example.ui.model.MyModel;;

public class SaveManager {
    // INSTANCE VARIABLES
    private static final String SAVE_FILE = "save.json";
    private static final Gson gson = new Gson();

    // METHODS
    public static void save(MyModel model) {
        try (Writer writer = new FileWriter(SAVE_FILE)) {
            gson.toJson(new ModelData(model.getName(), model.getAge()), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyModel load() {
        try (Reader reader = new FileReader(SAVE_FILE)) {
            ModelData data = gson.fromJson(reader, ModelData.class);
            MyModel model = new MyModel();
            if(data != null) {
                model.setName(data.name);
                model.setAge(data.age);
                model.initPlayer();
                return model;
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    // HELPER CLASS
    private static class ModelData {
        // INSTANCE VARIABLES
        String name;
        int age;

        // CONSTRUCTOR
        public ModelData(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}