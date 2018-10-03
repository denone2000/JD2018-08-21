package by.it.korolchuk.jd02_03;

import java.util.*;


public class Basket {

    private static List<String> keys = new ArrayList<>();

    public void put(String name) {

        keys.add(name);
    }

    List<String> getKeys() {
        return keys;
    }

}
