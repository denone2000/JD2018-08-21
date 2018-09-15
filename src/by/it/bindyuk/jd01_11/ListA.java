package by.it.bindyuk.jd01_11;

import java.util.*;

class ListA<T> implements List<T> {
    private int size = 0;
    private T[] array = (T[]) new Object[]{};
    public ListA() {
    }

    @Override
    public boolean add(T t) {
        if (size == array.length)
            array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
        array[size++] = t;
        return true;
    }

    @Override
    public T remove(int index) {
        T elementForRemove = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return elementForRemove;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i <size ; i++) {
            sb.append(delimeter);
            sb.append(array[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

////FICTIONS

    @Override
    public void add(int index, T element) {

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
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
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
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
