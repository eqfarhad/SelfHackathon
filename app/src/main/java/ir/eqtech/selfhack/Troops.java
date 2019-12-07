package ir.eqtech.selfhack;

import java.util.LinkedList;
import java.util.List;

public class Troops {
    private List<Character> troops;

    public Troops(List<Character> troops){
        this.troops = troops;
    }

    public  Troops() {
        this.troops = new LinkedList<>();
    }

    public void addTroop(Character troop){
        this.troops.add((troop));
    }

    public int getTroopsLength() {
        return this.troops.size();
    }

    public Character getTroopAt(int i) {
        return troops.get(i);
    }
}
