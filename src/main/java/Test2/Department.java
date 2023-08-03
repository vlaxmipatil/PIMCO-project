package Test2;

import java.util.Map;

public class Department {
    private Map<String, Division> divisions;
    private int floor;

    public Department(Map<String, Division> divisions, int floor) {
        this.divisions = divisions;
        this.floor = floor;
    }

    public Map<String, Division> getDivisions() {
        return divisions;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Department{" +
                "divisions=" + divisions +
                ", floor=" + floor +
                '}';
    }
}
