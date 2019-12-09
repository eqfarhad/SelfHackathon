package ir.eqtech.selfhack;

import java.io.Serializable;
import java.util.List;

public class PlayerData implements Serializable {
    private Character character;
    private int id;
    private Troops fighters = new Troops();
    private Troops troops;
    private DetectedPlayers detectedPlayers = new DetectedPlayers();

    public PlayerData(int id, Character character, Troops troops){
        this.id = id;
        this.character = character;
        this.troops = troops;
    }

    public PlayerData(int id, Character character) {
        this.id = id;
        this.character = character;
        this.troops = new Troops();
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

    public int getId() {
        return this.id;
    }

    public void addDetectedPlayer(PlayerData detectedPlayer){
        this.detectedPlayers.add(detectedPlayer);
    }

    public List<PlayerData> getDetectedPlayers() {
        return detectedPlayers.getPlayers();
    }

    public String getName() {
        return this.character.getName();
    }
}
