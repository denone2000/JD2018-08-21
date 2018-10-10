package by.it.artemliashkov.jd01_11;

import java.util.*;

public class ListA <T> implements List<T> {

    private T[]array= (T[]) new Object[]{};
    private Integer size=0;
    @Override


    public boolean add(T element) {
        if(size==array.length)
            array=Arrays.copyOf(array,(size*3)/2+1);
        array[size++]=element;
        return true;
    }



    @Override
    public T remove(int index) {
        T element=array[index];
        System.arraycopy(array,index+1,array,index,size-index-1);
        size--;
        return  element;
    }

    @Override
    public T get(int index) {
        return array[index];
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        String delemiter="";
        for (int i = 0; i < size; i++) {
            sb.append(delemiter).append(array[i]);
            delemiter=", ";
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean remove(Object o)
    {
        int index=indexOf(o);
        if(index>-1)
            remove(index);
        return (index>-1);
    }

    @Override
    public int indexOf(Object o) {
        if(o==null)
        {
            for (int i = 0; i < size; i++) {
                if(array[i]==null)
                    return i;
            }
        }
        else
        {
            for (int i = 0; i < size; i++) {
                if(o.equals(array[i]))
                    return i;
            }
        }
        return -1;
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
    public void add(int index, T element) {

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
