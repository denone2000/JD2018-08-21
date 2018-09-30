package by.it.galushka.jd02_03;

import java.util.Map;

public interface IBuyer {
    void enterToMarket();
    Map<String, Double> chooseGoods();
    void goOut();
}
