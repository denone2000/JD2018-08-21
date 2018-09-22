package by.it.nesterovich.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private ArrayList<Integer> arrayKey = new ArrayList<>();
    private ArrayList<T> arrayObject = new ArrayList<>();
//    int size =0;
//    private Object<T>[] arrayObject = new Object<>[100];

    @Override
    public boolean add(T t) {
        int key = t.hashCode();
        if (arrayKey.size() == 0) {
            arrayKey.add(key);
            arrayObject.add(t);
        } else {
            for (Integer elem : arrayKey) {   //использовать итератор
                if (elem == t.hashCode()) {
                    return false;
                }
            }
            arrayKey.add(key);
            arrayObject.add(t);
        }
        return true;
        //return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return arrayKey.size();
        //return  size;
    }

    @Override
    public boolean isEmpty() {
        return arrayKey.size() == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        String delimiter = "";
        for (T elem : arrayObject) {
            sb.append(delimiter).append(elem);
            delimiter = ", ";
        }
        sb.append(']');
        return sb.toString();
    }

    //дальше не лезь :)

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
