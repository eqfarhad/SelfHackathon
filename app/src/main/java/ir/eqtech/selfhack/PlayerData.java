package ir.eqtech.selfhack;

public class PlayerData {
    private Character character;
    private Troops fighters;
    private Troops troops;

    public PlayerData(Character character, Troops troops){
        this.character = character;
        this.troops = troops;
        this.fighters = new Troops();
    }

    public PlayerData(Character character) {
        this.character = character;
        this.troops = new Troops();
        this.fighters = new Troops();
    }

    public Character getCharacter() {
        return character;
    }

    public int getFighterAmount() {
        return fighters.getTroopsLength();
    }

    public Character getFighterAt(int i) {
        return this.fighters.getTroopAt(i);
    }
}
