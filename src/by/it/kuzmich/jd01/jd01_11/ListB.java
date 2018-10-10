package by.it.kuzmich.jd01.jd01_11;


import java.util.*;

public class ListB<T> implements List<T> {
    private T[] arr = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public boolean add(T t) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, ((arr.length * 3) / 2) + 1);
        }
        arr[size++] = t;
        return true;
    }

    @Override
    public T remove(int index) {
        T element = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return element;
    }
    @Override
    public T set(int index, T element) {
        T old=arr[index];
        arr[index]=element;
        return old;
    }
    @Override
    public void add(int index, T element) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, ((arr.length * 3) / 2) + 1);
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimit = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimit).append(arr[i]);
            delimit = ", ";
        }
        sb.append("]");
        String out = sb.toString();
        return out;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            if (size == arr.length) {
                arr = Arrays.copyOf(arr, ((arr.length * 3) / 2) + 1);
            }
            arr[size++] =t;
        }
        return true;
    }
    //end
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