package rexxie.sessions;

import rexxie.entities.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersSession {
    private List<Player> players = new ArrayList<>();
    private int currentUserPosition = -1;

    public void addPlayer(Player player) {
        players.add(player);
        players = players.stream()
                .sorted(Comparator.comparing(Player::getCellContent))
                .collect(Collectors.toList());
    }

    public Player nextPlayer() {
        currentUserPosition++;
        if (currentUserPosition >= players.size()) {
            currentUserPosition = 0;
        }
        return players.get(currentUserPosition);
    }

    public void restart() {
        currentUserPosition = -1;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
