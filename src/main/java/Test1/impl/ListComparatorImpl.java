package Test1.impl;

import Test1.api.ListComparator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListComparatorImpl implements ListComparator {

    @Override
    public List<Integer> minus(List<Integer> listA, List<Integer> listB) {
        Set<Integer> setA = new HashSet<>(listA);
        Set<Integer> setB = new HashSet<>(listB);
        setA.removeAll(setB);
        return new ArrayList<>(setA);
    }
}
