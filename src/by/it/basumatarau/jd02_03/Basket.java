package by.it.basumatarau.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Basket {

   private List<String> goods = new ArrayList<>();
   void addGood(String goodName){
       goods.add(goodName);
   }
   List<String> getGoods(){
       return goods;
   }
}
