package model;

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

    public Pokemon getPoke(String namePoke){
        System.out.printf(namePoke);
        return null;
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
}
