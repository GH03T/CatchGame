package com.example.game;

import java.util.Random;

public class Creature {
    // INSTANCE VARIABLES
    private static Random rand = new Random();

    private final String name;
    private int dexNum; // Index on the dex 
    private String nickname; // User-perfered name

    private int atk, def, spd, hp; // Stats
        
    // CONSTRUCTOR
    public Creature(String name, int dexNum) {
        // Initialise Instance Variables
        this.name = name;
        this.dexNum = dexNum;
        
        this.nickname = name;

        // Randomly Set Stats
        this.atk = rand.nextInt(10);
        this.def = rand.nextInt(10);
        this.spd = rand.nextInt(10);
        this.hp = 10 + rand.nextInt(10);
    }

    // METHODS
    public void levelUp(){
        this.atk += rand.nextInt(3);
        this.def += rand.nextInt(3);
        this.spd += rand.nextInt(3);
        this.hp += rand.nextInt(3);
    }
    
    public String getStats() {
        String message = "";
        message += ("HP\t: " + hp + "\n");
        message += ("Attack\t: " + atk + "\n");
        message += ("Defence\t: " + def + "\n");
        message += ("Speed\t: " + spd + "\n");

        return message;
    }
    
    // GETTERS & SETTERS
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public String getNickname(){
        return this.nickname;
    }
    
    public int getDexNum(){
        return this.dexNum;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAtk(){
        return this.atk;
    }
    
    public int getDef(){
        return this.def;
    }
    
    public int getSpd(){
        return this.spd;
    }
    
    public int getHP(){
        return this.hp;
    }
}
