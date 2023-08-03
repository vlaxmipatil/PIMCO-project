package Test2;

import java.util.Map;

public class Division {
    private Map<String, SubDivision> subDivisions;
    private int floor;

    public Division(Map<String, SubDivision> subDivisions, int floor) {
        this.subDivisions = subDivisions;
        this.floor = floor;
    }

    public Map<String, SubDivision> getSubDivisions() {
        return subDivisions;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Division{" +
                "subDivisions=" + subDivisions +
                ", floor=" + floor +
                '}';
    }
}
