package by.it.kuzmich.jd02.jd_02_01;

import java.util.Map;
import java.util.Set;

import static by.it.kuzmich.jd02.jd_02_01.Market.tovari;

public class  Buyer extends Thread implements IBuyer, IUseBucket {

    Buyer (int num){
        super("Покупатель "+num);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName()+" вошел в магазин");
    }
    @Override
    public void takeBacket(){
        int random = Utility.random(100, 200);
        Utility.sleep(random);
        System.out.println(this.getName()+" взял корзину");
    }


    @Override
    public void chooseGoods() {
        int random1 = Utility.random(1, 4);
        for (int i = 0; i <random1 ; i++) {
            int random = Utility.random(500, 2000);
            Utility.sleep(random);
            System.out.println(this.getName() + " выбирает товар");//выбрал товар (от 0,5 до 2 секунд)
            putGoodsToBacket();
        }
    }

    @Override
    public void putGoodsToBacket() {
        int random = Utility.random(100, 200);
        Utility.sleep(random);
        String kff = choose();
        System.out.println(this.getName()+" положил "+kff+" в корзину");
    }
    private String choose() {
        int count = 0;
        int size = (tovari.size()-1);
        int choose = Utility.random(size);
        Set<Map.Entry<String, Integer>> entries = tovari.entrySet();
        for (Map.Entry<String, Integer> next : entries) {
            if (count != choose) {
                count++;
            }
            else{
                return next.getKey();
            }
        }
        return  null;
    }

    @Override
    public void goOut() {
        System.out.println(this.getName()+" вышел из магазина");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }
}
