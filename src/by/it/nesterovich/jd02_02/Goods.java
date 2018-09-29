package by.it.nesterovich.jd02_02;

class Goods {

    private Integer price;
    private String goods;

    Goods() {
        this.price = Util.random(1, 100);
        this.goods = "goods" + String.valueOf(price);
    }

    Integer getPrice() {
        return price;
    }

    String getGoods() {
        return goods;
    }
}
