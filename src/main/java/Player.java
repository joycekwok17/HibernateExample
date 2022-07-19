import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "Player_Name")
    private String playerName;
//    @OneToOne
//    private Team team;
    @OneToMany
    List<Team> teamlist = new ArrayList<>();

    public Player() {
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player(String playerName, List<Team> teamlist) {
        this.playerName = playerName;
        this.teamlist = teamlist;
    }

    public List<Team> getTeamlist() {
        return teamlist;
    }

    public void setTeamlist(List<Team> teamlist) {
        this.teamlist = teamlist;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", teamDetails='" + playerName + '\'' +
                ", teamName='" + teamlist + '\'' +
                '}';
    }
}
