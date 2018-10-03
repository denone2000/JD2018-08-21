//package by.it.voinilo.jd02.jd02_01;
//
//import java.util.HashMap;
//
//import static java.lang.Thread.sleep;
//
//public class Buyer extends Thread implements  IBuyer,Runnable,IUseBusket {
////    static HashMap<String, Integer> pricelist = new HashMap<String, Integer>();{}
////        pricelist.put("bread", 1);
////        pricelist.put("milk", 2);
////        pricelist.put("ice cream", 3);
////        pricelist.put("salt", 1);
//    int num;
//    int status = Custom.rndAtoB(1,4);
//    int pause = Custom.rndAtoB(100,200);
//
//    public Buyer(int nomer) {
//        this.num = nomer;
//        this.setName("Buyer nomber" + nomer + " ");
//        start();
//
//    }
//аааааааааааапааа
//    @Override
//    public void run() {
//
//        try {
//            enterToMarket();
//            takeBacket();
//            chooseGoods();
//            putGoodsToBacket();
//            goOut();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public void enterToMarket() {
//        System.out.println(this + "entered the marked");
//
//
//    }
//
//    @Override
//    public void chooseGoods() {
//
//
//
//        try {
//            int pause = Custom.rndAtoB(500,2000);
//            if (status == 4){
//                sleep((long) (pause*1.50));}
//            sleep(pause);
//        } catch (InterruptedException e) {
//            System.out.println("Incorrect waiting ending");
//        }
//
//        System.out.println(this + "have chosen goods");
//
//    }
//
//    @Override
//    public void goOut() throws InterruptedException {
//        if (status == 4){
//            sleep((long) (pause*1.50));}
//        else
//        System.out.println(this +"leaved the market");
//
//    }
//
//    @Override
//    public String toString() {
//        return this.getName();
//
//    }
//
//    @Override
//    public void takeBacket() {
//        try {
//            System.out.println("buyer number " + num+"has taken the backet");
//            int pause = Custom.rndAtoB(100,200);
//            if (status == 4){
//                sleep((long) (pause*1.50));}
//                else
//            sleep(pause);
//
//        } catch (InterruptedException e) {
//            System.out.println("Incorrect waiting ending");
//        }
//    }
//
//    @Override
//    public void putGoodsToBacket() {
//        try {
//
//
//            HashMap<String,Integer> list = new HashMap<String, Integer>() ;
//
//            for (int i = 0; i < Custom.rndAtoB(1,4); i++) {
//                int price = Custom.rndAtoB(80, 500);
//                String good = "product" ;
//                list.put(good, price);
//                System.out.print(this + " put to his basket " + good + " with price " + price);
//                if (status == 4)System.out.println(" (pens)");
//                System.out.println(" ");
//                if (status == 4){
//                    sleep((long) (pause*1.50));
//                }else sleep(pause);
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Incorrect waiting ending");
//        }
//
//
//
//        }
//
//
//
//    }
