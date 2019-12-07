package ir.eqtech.selfhack;

import androidx.annotation.NonNull;

enum Role {
    KNIGHT,
    PRIEST,
    HUNTER,
}

enum Race {
    ORK,
    HUMAN,
    ELB,
    DWARF
}

public class Character {
    private String name;
    private int lvl;
    private int xp;
    private int attack;
    private int health;
    private int speed;
    private int defense;
    private Race race;
    private Role role;

    public Character(String name, Race race, Role role){
        this.name = name;
        this.race = race;
        this.role = role;
        this.lvl = 0;
        this.xp = 0;
        this.attack = 1;
        this.health = 1;
        this.speed = 1;
        this.defense = 1;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public float getFightValue() {
        return (float) (this.attack * this.defense * this.health * this.speed);
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
