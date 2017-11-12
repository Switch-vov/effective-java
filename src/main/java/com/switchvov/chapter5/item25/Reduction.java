package com.switchvov.chapter5.item25;// List-based generic reduction - Page 123

import java.util.*;

public class Reduction {
    static <E> E reduce(List<E> list, Function<E> f, E initVal) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<>(list);
        }
        E result = initVal;
        for (E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    // A few sample functions
    private static final Function<Integer> SUM = (i1, i2) -> i1 + i2;

    private static final Function<Integer> PRODUCT = (i1, i2) -> i1 * i2;

    private static final Function<Integer> MAX = Math::max;

    private static final Function<Integer> MIN = Math::min;

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(
                2, 7, 1, 8, 2, 8, 1, 8, 2, 8);
        // Reduce intList using each of the above reducers
        System.out.println(reduce(intList, SUM, 0));
        System.out.println(reduce(intList, PRODUCT, 1));
        System.out.println(reduce(intList, MAX, Integer.MIN_VALUE));
        System.out.println(reduce(intList, MIN, Integer.MAX_VALUE));
    }
}
