package Test2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FloorAssignmentPlanTest {
    FloorAssignmentPlan plan = new FloorAssignmentPlan();

    @Test
    public void testSingleDeptFloor(){
        assert plan.lookupFloor(Arrays.asList("Tech")) == 10;
        assert plan.lookupFloor(Arrays.asList("Business")) == 2;
    }

    @Test
    public void testMultipleLevelFloor(){
        assert plan.lookupFloor(Arrays.asList("Tech","Infra")) == 5;
        assert plan.lookupFloor(Arrays.asList("Tech","Infra","Database")) == 7;
        assert plan.lookupFloor(Arrays.asList("Tech","Infra","Network")) == 8;
        assert plan.lookupFloor(Arrays.asList("Tech","Application")) == 10;
        assert plan.lookupFloor(Arrays.asList("Tech","Application","trading")) == 3;
        assert plan.lookupFloor(Arrays.asList("Tech","Application","trading","rates")) == 4;
        assert plan.lookupFloor(Arrays.asList("Tech","Application","trading","equity")) == 11;
        assert plan.lookupFloor(Arrays.asList("Tech","Application","compliance")) == 6;
        assert plan.lookupFloor(Arrays.asList("Business","FrontOffice")) == 1;
        assert plan.lookupFloor(Arrays.asList("Business","MiddleOffice")) == 1;
    }

    @Test
    public void testNonexistentUnit() {
        assert plan.lookupFloor(Arrays.asList("Tech", "application", "sales", "commodities")) == 10;
    }
}
