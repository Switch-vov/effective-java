package com.switchvov.chapter10.item67;// Simple test of ObservableSet - Page 266

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver((s, e) -> System.out.println(e));
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
