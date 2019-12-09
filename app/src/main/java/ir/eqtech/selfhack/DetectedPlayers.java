package ir.eqtech.selfhack;

import java.util.LinkedList;
import java.util.List;

public class DetectedPlayers {
    private List<PlayerData> newPlayers = new LinkedList<PlayerData>();
    private List<PlayerData> players = new LinkedList<PlayerData>();

    private static void removeFromList(PlayerData playerData, List<PlayerData> list){
        int id = playerData.getId();
        PlayerData playerToBeRemoved = null;
        for (PlayerData player: list
             ) {
            if(player.getId() == id){
                playerToBeRemoved = player;
                break;
            }
        }
        if(playerToBeRemoved != null){
            list.remove(playerToBeRemoved);
        }
    }

    public void add(PlayerData playerData){
        removeFromList(playerData, this.newPlayers);
        removeFromList(playerData, this.players);
        this.newPlayers.add(playerData);
        this.players.add(playerData);
    }

    public List<PlayerData> getPlayers() {
        return this.players;
    }
}
