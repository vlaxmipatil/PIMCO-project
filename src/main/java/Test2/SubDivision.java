package Test2;

import java.util.Map;

public class SubDivision {
    private Map<String, Team> teams;
    private int floor;

    public SubDivision(Map<String, Team> teams, int floor) {
        this.teams = teams;
        this.floor = floor;
    }

    public Map<String, Team> getTeams() {
        return teams;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "SubDivision{" +
                "teams=" + teams +
                ", floor=" + floor +
                '}';
    }
}
