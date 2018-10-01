package by.it.basumatarau.jd02_03;

import java.util.Map;

class Util {

    static int random(int from, int to){
        return (int)(Math.random()*(to-from)+from+1);
    }

    static int random(int notExceeding){
        return (int)(Math.random()*(notExceeding+1));
    }

    static void sleep(int ms){
        try{
            Thread.sleep(ms/Dispatcher.KSPEED);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    static String printMarketStatus(){
        StringBuilder[] sb = new StringBuilder[11];
        for (int i = 0; i < sb.length; i++) {
            sb[i]=new StringBuilder();
        }

        for (Map.Entry<Object, Cashier> entry : Dispatcher.getCashierMonitors().entrySet()) {
            synchronized (entry.getKey()){
                sb[0].append(String.format("%-15s",entry.getValue().toString()));
                if(entry.getValue().isWorking()&&entry.getValue().getCurrBuyer()!=null){

                    sb[1].append(String.format("%-15s","open"));
                    sb[2].append(String.format("%-15s","is servicing:"));
                    sb[3].append(String.format("%-15s", entry.getValue().getCurrBuyer().getName()));
                    sb[4].append(String.format("%-15s", entry.getValue().getCurrBuyer().isPensioner()?"pensioner":"not pensioner"));
                    sb[5].append(String.format("%-15s","Has bought:"));
                    int i=5;
                    for (String good : entry.getValue().getCurrBuyer().putGoodsOutOfBasket()) {
                        sb[++i].append(String.format("%d.%-13s",i-5,good));
                    }
                    sb[++i].append(String.format("%-15s",String.format("Bill:%.2f$",entry.getValue().getCurrentBuerBill())));
                    while(i<10){
                        sb[++i].append(String.format("%-15s",""));
                    }
                }
                else{
                    sb[1].append(String.format("%-15s","closed"));
                    int i = 1;
                    while(i<10){
                        sb[++i].append(String.format("%-15s",""));
                    }
                }
            }
        }
        sb[0].append(String.format("%-15s", "Queue size:"));
        sb[1].append(String.format("%-15d", Buyer.queuingBuyers()));

        sb[0].append(String.format("%-15s", "Total Revenue:"));
        sb[1].append(String.format("%15s$", Cashier.getTotalRevenue()));

        StringBuilder result = new StringBuilder();
        for (StringBuilder aSb : sb) {
            result.append(aSb.append("\n"));
        }

        return result.toString();
    }
}
