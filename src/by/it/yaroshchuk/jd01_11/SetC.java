package by.it.yaroshchuk.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[])new Object []{};
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if(o.equals(element))
                return true;
        }
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
    public boolean add(T t) {
        for (T element : elements) {
            if (t.equals(element)) {
                return false;
            }
        }
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index > -1)
            remove(index);
        return (index > -1);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            for (T element : elements) {
                if(o.equals(element) == false)
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object array = c.toArray();
        int arraySize = ((Object[]) array).length;
        int newLength = (size * 3) / 2 + 1;
        if(arraySize == 0)
            return false;

        for (T t : c) {

            add(t);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(Object o){
        if(o == null){
            for (int i = 0; i < elements.length; i++) {
                if(elements[i] == null)
                    return i;
            }
        }
        else {
            for (int i = 0; i < elements.length; i++) {
                if(o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }
}
