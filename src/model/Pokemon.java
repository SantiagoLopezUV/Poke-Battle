package model;

import org.json.JSONArray;
import org.json.JSONObject;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private String urlSprite;
    private int currentHp;

//    public Pokemon getPoke(String namePoke){
//        System.out.printf(namePoke);
//        return null;
//    }

    public Pokemon(){}

    public boolean isFatality() { // para verficar si el hp del pokemon esta en 0
        return this.currentHp <= 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public String getUrlSprite() {
        return urlSprite;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setUrlSprite(String urlSprite) {
        this.urlSprite = urlSprite;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
}
