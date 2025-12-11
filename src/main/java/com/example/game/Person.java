package com.example.game;

import java.util.*;

public class Person {
    // INSTANCE VARIABLES
    private static Random rand = new Random();

    private final String name;
    private final int age;

    private ArrayList<Creature> team = new ArrayList<Creature>();
    private HashMap<Integer, String> dex = new HashMap<>();

    // CONSTRUCTOR
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // METHODS
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    // Add Creature To Team & Dex
    public void caught(Creature c){
        this.team.add(c);
        dex.put(c.getDexNum(), c.getName());
    }
    
    // Return String of Team
    public String getTeam(){
        String message = "";
        for(Creature c : team){
            message += ("Name\t: " + c.getNickname() + "\n");
            message += c.getStats() + "\n";
            message += "\n";
        }
        return message;
    }
    
    // Return String of Dex Items
    public String getDex() {
        String message = "";
        for(Map.Entry<Integer, String> entry : dex.entrySet()) {
            message += (entry.getKey() + ". " + entry.getValue() + "\n");
        }
        return message;
    }
    
    // Catch a Boblet
    public String catchBoblet() {
        // If 1/3rd Chance, Catch a...
        if(rand.nextInt(3) == 0) {
            String message = "Congrats! You have caught ";
            switch(rand.nextInt(5)){
                case 0:
                    caught(new Creature("Boblet", 1));
                    return message + "a boblet!";
                case 1:
                    caught(new Creature("Snail", 2));
                    return message + "a snail!";
                case 2:
                    caught(new Creature("Witch", 3));
                    return message + "a witch!";
                case 3:
                    caught(new Creature("Cat", 4));
                    return message + "a cat!";
                case 4:
                    caught(new Creature("Sentient Shoe", 5));
                    return message + "a sentient shoe!";
            }
        }

        // Else, return a message
        String[] messages = {
            "The cat has scaled a tree!",
            "A factitious boblet has avoided your land.",
            "The werewolf squeals like expired land-o-lakes cheese.",
            "Your challenger avoids you out of distress."
        };

        return messages[rand.nextInt(messages.length)];
    }

    // Abandon Catching Boblet
    public String runAway() {
        String[] messages = {
            "You have avoided a boblet.",
            "Thus shall be saved.",
            "The werewolf howls in peace.",
            "The cat gives a wink goodbye.",
            "Your challenger resents you."
        };

        return messages[rand.nextInt(messages.length)];
    }
}