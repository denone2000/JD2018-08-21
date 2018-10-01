package by.it.basumatarau.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

class Basket {
    private static ArrayBlockingQueue<Basket> BASKETS_IN_USE = new ArrayBlockingQueue<>(50);
    private Basket(){

    }

    static Basket getBasket(){
        Basket basket = new Basket();
        try {
            BASKETS_IN_USE.put(basket);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return basket;
    }

    static void returnBasket(){
        BASKETS_IN_USE.poll();
    }

   private List<String> goods = new ArrayList<>();
   void addGood(String goodName){
       goods.add(goodName);
   }
   List<String> getGoods(){
       return goods;
   }
}
