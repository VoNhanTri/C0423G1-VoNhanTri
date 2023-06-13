package bai_3.model;

import java.util.Objects;

public class Player {
    private String code;
    private String name;
    private String date;
    private String dress;
    private String team;

    public Player() {
    }

    public Player(String code, String name, String date, String dress, String team) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.dress = dress;
        this.team = team;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(code, player.code) && Objects.equals(name, player.name) && Objects.equals(date, player.date) && Objects.equals(dress, player.dress) && Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, date, dress, team);
    }

    @Override
    public String toString() {
        return "Player{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", dress='" + dress + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
