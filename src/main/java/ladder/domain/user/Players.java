package ladder.domain.user;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> players) {
        this.players = toPlayers(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int size() {
        return players.size();
    }

    private List<Player> toPlayers(List<String> players) {
        return players.stream()
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }

}