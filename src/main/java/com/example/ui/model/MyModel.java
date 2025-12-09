package com.example.ui.model;

import com.example.game.Person;

import java.util.Random;

public class MyModel {
    // INSTANCE VARIABLES
    static final Random Rand = new Random();

    private Person player;

    private String inputNameText = "Let's start with you typing your name!";
    private String inputAgeText = "Next, how old are you?";
    private String mainGreeting;

    private String name;
    private int age;

    private boolean isLoaded;

    // METHODS
    public void initPlayer() {
        player = new Person(name, age);
    }

    // GETTERS & SETTERS
    public Person getPlayer() {
        return player;
    }

    public String getInputNameText() {
        return inputNameText;
    }

    public String getInputAgeText() {
        return inputAgeText;
    }

    public String getGreeting() {
        return mainGreeting;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        // Set Name
        if(name.isBlank()) {
            name = "Player";
        } else {
            this.name = name.strip();
        }

        mainGreeting = "Welcome, " + name + "!"; // Set Greeting
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAgeString(String input) {
        // Set Age
        if(input.isBlank()) {
            this.age = 18;
        } else {
            try {
                this.age = Integer.parseInt(input.strip());
            } catch(Exception e) {
                this.age = 18;
            }
        }
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void isLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
    }
}