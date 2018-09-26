package by.it.artemliashkov.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class UseBasket extends Thread implements IUseBasket {
    private Map<String, Integer> goods = new HashMap<>();

    UseBasket(int number) {
        super("Покупатель №"+number);
    }

    public void run()
    {
        goods.put("Молоко", 10000);
        goods.put("Сахар", 7500);
        goods.put("Кефир", 6700);
        goods.put("Йогурт", 3000);
        goods.put("Сыр",47000);
        goods.put("Квас",12000);
        goods.put("Колбаса",30000);
        takeBasket();
        putGoodsToBasket();
    }

    @Override
    public void takeBasket() {
        try {
            System.out.println(this+ "взял корзину");
            sleep((int)(100+Math.random()*101));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String indexBasket(int arrayGoods) {
        String indexValue;
        switch (arrayGoods) {
            case 1:
                indexValue = "Молоко";
                break;
            case 2:
                indexValue = "Сахар";
                break;
            case 3:
                indexValue = "Кефир";
                break;
            case 4:
                indexValue = "Йогурт";
                break;
            case 5:
                indexValue = "Сыр";
                break;
            case 6:
                indexValue = "Квас";
                break;
            case 7:
                indexValue = "Колбаса";
                break;
            default:
                indexValue = "Incorrect value";
                break;

        }
        return indexValue;
    }

    @Override
    public void putGoodsToBasket() {
        int iterators= (int) (1+Math.random()*4);
        int arrayGoods=(int) (1+Math.random()*7);
        String indexValue= indexBasket(arrayGoods);
        for (int i = 0; i < iterators; i++) {
            try {
                System.out.println(this+ "взял товар");
                for( Map.Entry<String, Integer> entry : goods.entrySet() ){
                    if( indexValue.equals( entry.getKey() ) )
                       System.out.println( entry.getKey() + " " + entry.getValue() );
                }
                sleep((int)(100+Math.random()*101));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public String toString()
    {
        return this.getName();
    }
}
