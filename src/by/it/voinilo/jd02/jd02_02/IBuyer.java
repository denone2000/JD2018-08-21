package by.it.voinilo.jd02.jd02_02;

public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void enterQueue() throws InterruptedException;
    void goOut() throws InterruptedException;
}
