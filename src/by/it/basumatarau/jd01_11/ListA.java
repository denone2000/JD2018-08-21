package by.it.basumatarau.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {
    private T[] array = (T[]) new Object[]{};
    private int size = 0;
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String delimiter = "[";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(array[i]);
            delimiter = ", ";
        }
        sb.append(']');
        return sb.toString();
    }
    @Override
    public T remove(int i) {
        T item = array[i];
        System.arraycopy(array, i+1, array, i, array.length - i -1);
        size--;
        return item;
    }

    @Override
    public T get(int i) {
        if(i>=size||i<0) return null;
        return array[i];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean add(T item) {
        if(size==array.length){
            array = Arrays.copyOf(array, (array.length*3)/2 + 1);
        }
        array[size++]=item;
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int i, T t) {
        return null;
    }

    @Override
    public void add(int i, T t) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
}
