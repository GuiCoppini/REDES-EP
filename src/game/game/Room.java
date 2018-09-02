package game.game;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private Table table = new Table();
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void printPlayers() {
        for(Player p : players) {
            if (p != null)
                System.out.println(p.getName());
        }
    }
}
