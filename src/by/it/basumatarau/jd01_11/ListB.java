package by.it.basumatarau.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private T[] array = (T[])new Object[0];
    int size = 0;

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (size<=(array.length+collection.size())) array = Arrays.copyOf(array, (array.length+collection.size())*3/2 + 1);
        Iterator<? extends T> iterator = collection.iterator();
        while(iterator.hasNext()){
            array[size++]=iterator.next();
        }
        return true;
    }

    @Override
    public boolean add(T obj) {
        if (size==array.length) array = Arrays.copyOf(array, array.length*3/2 + 1);
        array[size++]=obj;
        return true;
    }

    @Override
    public void add(int index, T obj) {
        if (index>size||index<0) return;
        if (size==array.length) array = Arrays.copyOf(array, array.length*3/2 + 1);
        System.out.println("array length" + array.length);
        System.arraycopy(array, index, array, index+1, size-index);
        array[index]=obj;
        size++;
    }

    @Override
    public T set(int index, T obj) {
        if (index>=size||index<0) return null;
        T replaced = array[index];
        array[index]=obj;
        return replaced;
    }

    @Override
    public T get(int index) {
        if (index>=size||index<0) return null;
        return array[index];
    }

    @Override
    public T remove(int index) {
        if (index>=size||index<0) return null;
        T obj = array[index];
        System.arraycopy(array, index+1, array, index, size - index);
        size--;
        return obj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = "[";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(array[i]);
            delimiter = ", ";
        }
        if(delimiter.equals("["))sb.append("[");
        sb.append("]");
        return sb.toString();
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
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
