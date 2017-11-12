package com.switchvov.chapter5.item28;// Generic union method with wildcard types - Pages 137-138

import java.util.*;

public class Union {

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise flexible generic method
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1); 
        integers.add(3); 
        integers.add(5); 

        Set<Double> doubles = new HashSet<>();
        doubles.add(2.1);
        doubles.add(4.1);
        doubles.add(6.0); 

        Set<Number> numbers = union(integers, doubles);

        System.out.println(numbers);
    }
}
