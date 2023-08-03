package Test2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FloorAssignmentPlan {
    Map<String, Department> departmentMap = new ConcurrentHashMap<>();

    public FloorAssignmentPlan() {
        Map<String, Team> teamMap = new HashMap<>();
        teamMap.putIfAbsent("rates", new Team(4));
        teamMap.putIfAbsent("equity", new Team(11));

        Map<String, SubDivision> infraSubdivMap = new HashMap<>();
        infraSubdivMap.putIfAbsent("Database", new SubDivision(null, 7));
        infraSubdivMap.putIfAbsent("Network", new SubDivision(null, 8));

        Map<String, SubDivision> applicationSubdivMap = new HashMap<>();
        applicationSubdivMap.putIfAbsent("trading", new SubDivision(teamMap, 3));
        applicationSubdivMap.putIfAbsent("compliance", new SubDivision(null, 6));

        Map<String, Division> techDivisionMap = new HashMap<>();
        techDivisionMap.putIfAbsent("Infra", new Division(infraSubdivMap, 5));
        techDivisionMap.putIfAbsent("Application", new Division(applicationSubdivMap, 0));

        Map<String, Division> businessDivisionMap = new HashMap<>();
        businessDivisionMap.putIfAbsent("FrontOffice", new Division(null, 1));
        businessDivisionMap.putIfAbsent("MiddleOffice", new Division(null, 1));

        departmentMap.putIfAbsent("Tech", new Department(techDivisionMap, 10));
        departmentMap.putIfAbsent("Business", new Department(businessDivisionMap, 2));
    }

    public Map<String, Department> getDepartmentMap() {
        return departmentMap;
    }

    @Override
    public String toString() {
        return "FloorAssignmentPlan{" +
                "departmentMap=" + departmentMap +
                '}';
    }

    public int lookupFloor(List<String> unit) {
        Map<String, Department> departmentMap = getDepartmentMap();
        String departmentName = unit.get(0);
        Department department = departmentMap.get(departmentName);
        if (department == null) {
            throw new IllegalArgumentException("Invalid department name: " + departmentName);
        }
        int floor = department.getFloor();;
        if (unit.size() == 1) {
            return floor;
        }

        String divisionName = unit.get(1);
        Map<String, Division> divisionMap = department.getDivisions();

        Division division = divisionMap.get(divisionName);
        if (division != null && division.getFloor() != 0) {
            floor = division.getFloor();
        }
        if (unit.size() == 2 || division == null) {
            return floor;
        }
        String subDivisionName = unit.get(2);
        Map<String, SubDivision> subDivisionMap = division.getSubDivisions();

        SubDivision subDivision = subDivisionMap.get(subDivisionName);
        if (subDivision != null && subDivision.getFloor() != 0) {
            floor = subDivision.getFloor();
        }
        if (unit.size() == 3) {
            return subDivision.getFloor() == 0 ? floor : subDivision.getFloor();
        }

        String teamName = unit.get(3);
        Map<String, Team> teamMap = subDivision.getTeams();

        Team team = teamMap.get(teamName);
        if (team != null && team.getFloor() != 0) {
            floor = team.getFloor();
        }
        return floor;
    }

}
