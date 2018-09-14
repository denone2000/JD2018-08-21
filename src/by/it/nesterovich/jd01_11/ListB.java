package by.it.nesterovich.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private T[] array = (T[]) new Object[]{};
    private int size = 0;

    ArrayList<T> list = new ArrayList<T>();


    @Override
    public boolean add(T element) {
        if (size == array.length)
            array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
        array[size++] = element;
        return true;
    }

    @Override
    public T remove(int index) {
        T element = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return element;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(array[i]);
            delimiter = ", ";
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public T set(int index, T element) {
        if (index > array.length) {
            array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
        }
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, T element) {
        if (index >= array.length) {
            array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if ((numNew + size) > numNew) {
             //array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
            //array = Arrays.copyOf(array, array.length + (numNew>size?numNew:size));
            array = Arrays.copyOf(array, array.length + (numNew>size?numNew:size));
        }
        System.arraycopy(a, 0, array, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    //дальше не лезь :)

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
        return Arrays.copyOf(array,array.length-1);
        //return  array.clone();
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
