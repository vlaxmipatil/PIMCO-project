package Test1.impl;

import Test1.api.ListComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListComparatorImplTest {

    @Test
    public void testMinusTest(){
        List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listB = Arrays.asList(2, 4, 6, 8, 10);
        ListComparator comparator = new ListComparatorImpl();
        List<Integer> result = comparator.minus(listA, listB);
        Assertions.assertEquals(Arrays.asList(1, 3, 5), result);
    }

    @Test
    public void testMinusSetAEmpty(){
        List<Integer> listA = Arrays.asList();
        List<Integer> listB = Arrays.asList(2, 4, 6, 8, 10);
        ListComparator comparator = new ListComparatorImpl();
        List<Integer> result = comparator.minus(listA, listB);
        Assertions.assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testMinusSetBEmpty(){
        List<Integer> listA = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> listB = Arrays.asList();
        ListComparator comparator = new ListComparatorImpl();
        List<Integer> result = comparator.minus(listA, listB);
        Assertions.assertEquals(Arrays.asList(1, 3, 5, 7, 9), result);
    }

    @Test
    public void testMinusSameList(){
        List<Integer> listA = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> listB = Arrays.asList(1, 3, 5, 7, 9);
        ListComparator comparator = new ListComparatorImpl();
        List<Integer> result = comparator.minus(listA, listB);
        Assertions.assertEquals(Arrays.asList(), result);
    }
}