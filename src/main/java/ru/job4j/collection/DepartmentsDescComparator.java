package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("/");
        String[] rightParts = right.split("/");
        int length = Math.min(leftParts.length, rightParts.length);

        for (int i = 0; i < length; i++) {
            int res;
            if (i == 0) {
                res = rightParts[i].compareTo(leftParts[i]);
            } else {
                res = leftParts[i].compareTo(rightParts[i]);
            }
            if (res != 0) {
                return res;
            }
        }
        return Integer.compare(leftParts.length, rightParts.length);
    }
}
