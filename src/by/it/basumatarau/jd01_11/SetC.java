package by.it.basumatarau.jd01_11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {
    private Bucket<T>[] buckets = new Bucket[INIT_CAPACITY];
    private int size =0;
    static private int INIT_CAPACITY = 128;
    private int capacity=INIT_CAPACITY;

    private class Bucket<T>{
        Bucket<T> nextEntry;
        T objRef;

        Bucket(T ob){
            objRef = ob;
        }
        private T getKey(){
            return objRef;
        }
        Bucket<T> getNext(){
            return nextEntry;
        }
        void setNext(Bucket<T> nextBucket){
            nextEntry = nextBucket;
        }
    }

    @Override
    public boolean add(T t) {
        int hash;
        if (t == null) {
            hash = 0;
        }else {
            hash = t.hashCode();
        }
        if(buckets[hash%capacity]!=null){
            Bucket<T> bucket = buckets[hash%capacity];
            if(bucket.getKey()==null&&t==null||
                    bucket.getKey()!=null&&bucket.getKey().equals(t)) return true;
            while(bucket.getNext()!=null) {
                bucket = bucket.getNext();
                if (bucket.getKey()==null&&t==null||
                        bucket.getKey()!=null&&bucket.getKey().equals(t)) return true;
            }
            bucket.setNext(new Bucket<>(t));
        }else buckets[hash%capacity]=new Bucket<>(t);

        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String delimiter = "[";
        for (Bucket<T> bucket : buckets) {
            while (bucket!=null){
                result.append(delimiter).append(bucket.getKey());
                delimiter = ", ";
                bucket = bucket.getNext();
            }
        }
        if (delimiter.equals("[")) result.append("[");
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> iterator = collection.iterator();
        while(iterator.hasNext()){
            T item = iterator.next();
            this.add(item);
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object item : collection) {
            this.remove(item);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if(!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int hash;
        if (o == null) {
            hash = 0;
        }else {
            hash = o.hashCode();
        }
        if(buckets[hash%capacity]!=null){
            Bucket<T> bucket = buckets[hash%capacity];
            if(bucket.getKey()!=null&&bucket.getKey().equals(o)||
            bucket.getKey()==null&&o==null){
                buckets[hash%capacity]=bucket.getNext();
                size--;
                return true;
            }
            Bucket<T> previous = bucket;
            bucket = bucket.getNext();
            while(bucket!=null){
                if(bucket.getKey()!=null&&bucket.getKey().equals(o)||
                bucket.getKey()==null&&o==null){
                    previous.setNext(bucket.getNext());
                    size--;
                    return true;
                }
                previous=bucket;
                bucket=bucket.getNext();
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        int hash;
        if (o == null) {
            hash = 0;
        }else {
            hash = o.hashCode();
        }

        if(buckets[Math.abs(hash%capacity)]!=null){
            Bucket<T> bucket = buckets[Math.abs(hash%capacity)];
            if(bucket.getKey()==null&&o==null||
                    bucket.getKey()!=null&&bucket.getKey().equals(o)) return true;
            while(bucket.getNext()!=null) {
                bucket = bucket.getNext();
                if (bucket.getKey()==null&&o==null||
                        bucket.getKey()!=null&&bucket.getKey().equals(o)) return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
            size = 0;
        }
    }






    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }
}
