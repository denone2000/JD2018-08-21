package by.it.korolchuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<String> keys = new ArrayList<>();

    public void put(String name) {
        keys.add(name);
    }

    List<String> getKeys() {
        return keys;
    }
}
