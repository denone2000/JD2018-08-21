package by.it.bindyuk.jd02_03;

import java.util.ArrayList;
import java.util.List;

class CashiersCollection {
    private static List<Cashier> collectCashiers = new ArrayList<>();

    static void addCashier(Cashier cashier) {
        collectCashiers.add(cashier);
    }

    static int collectCashiersSize() {
        return collectCashiers.size();
    }
}
