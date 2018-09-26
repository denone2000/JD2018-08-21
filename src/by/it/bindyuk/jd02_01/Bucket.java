package by.it.bindyuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Bucket {
    private List<String> bucket = new ArrayList<>();
    void putGood (String good){
        bucket.add(good);
    }
    List<String> getChosenGoods(){
        return bucket;
    }
}
