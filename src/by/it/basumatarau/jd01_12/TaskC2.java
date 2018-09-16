package by.it.basumatarau.jd01_12;

import java.util.*;

public class TaskC2 {

    //it works, but...
    static Set<Number> getUnion(Collection<? extends Number>  ...sets){
        if(sets == null) return null;
        Set<Number> result = new HashSet<>();
        for (Collection<? extends Number> set : sets) {
            Iterator<? extends Number> iterator = set.iterator();
            while(iterator.hasNext()){
                boolean found= false;
                Number var = iterator.next();
                for (Number number : result) {
                    if (number.doubleValue()==var.doubleValue()){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    result.add(var);
                }
            }
        }
        return result;
    }

    //it works, but...
    static Set<Number> getCross(Collection<? extends Number>  ...sets){
        if(sets == null) return null;
        Set<Number> result = new HashSet<>(sets[0]);

        for (Collection<? extends Number> set : sets) {
            Iterator<? extends Number> iterator = result.iterator();
            while(iterator.hasNext()){
                Number val = iterator.next();
                boolean included = false;
                for (Number number : set) {
                    if(number.doubleValue()==val.doubleValue()){ included = true; break;}
                }
                if(!included){
                    result.remove(val);
                    iterator = result.iterator();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Number> setOfShorts = new HashSet<>(Arrays.asList(new Short[]{1, 2, 3, 4, 5, 6}));
        Set<Number> setOfIntegers = new HashSet<>(Arrays.asList(new Integer[]{4, 5, 6, 7, 8, 9}));
        Set<Number> setOfDoubles = new HashSet<>(Arrays.asList(new Double[]{4.0, 5.0, 6.0, 7.7, 8.9, 9.156}));

        System.out.println(setOfShorts);
        System.out.println(setOfIntegers);
        System.out.println(setOfDoubles);

        System.out.println("cross: "+TaskC2.getCross(setOfShorts, setOfIntegers, setOfDoubles));
        System.out.println("union: "+TaskC2.getUnion(setOfShorts, setOfIntegers, setOfDoubles));
    }

    //OMG it works. (don't look down)
    static Set<Number> getCross2(Collection<? extends Number>... sets){
        Set<Number> result = new HashSet<>();
        Set<Number> swap = new HashSet<Number>(){
            @Override
            public boolean contains(Object o) {
                for (Number number : this) {
                    if(number.doubleValue()==((Number)o).doubleValue()){
                        return true;
                    }
                }
                return false;
            }
            @Override
            public boolean retainAll(Collection<?> collection) {
                boolean touched = false;
                Iterator<?> iterator = this.iterator();
                Object num;
                while (iterator.hasNext()) {
                    if(!collection.contains(num=iterator.next())){
                        collection.remove(num);
                        touched = true;
                    }
                    if(touched) {
                        iterator = this.iterator();
                        touched = false;
                    }
                }
                return false;
            }
        };
        result.addAll(sets[0]);
        for (Collection<? extends Number> set : sets) {
            swap.addAll(result);
            result.clear();
            result.addAll(set);
            result.retainAll(swap);
            swap.clear();
        }
        return result;
    }
}
