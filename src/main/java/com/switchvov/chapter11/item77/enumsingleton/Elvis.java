package com.switchvov.chapter11.item77.enumsingleton;// Enum singleton - the preferred approach - Page 311

import java.util.*;

public enum Elvis {
    INSTANCE;
    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}