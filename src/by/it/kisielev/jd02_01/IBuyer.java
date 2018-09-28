package by.it.kisielev.jd02_01;

//Каждый покупатель долджен выполнять эти действия
public interface IBuyer {
    void enterToMarket(); //заходит человек в магазин
    void chooseGoods(); //выберат товар с 0.5 до 2 секунд
    void goOut(); //покупатель выходит с маркета
}

