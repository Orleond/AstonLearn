/*
 * В Коллекции реализованы следующие методы: int size(), boolean isEmpty(),
 * boolean add(E), E get(int), boolean contains(Object), boolead addAll(Collection),
 * boolean remove(Object).
 *
 * Реализована сортировка пузырьком.
 */

package com.myproject.www.MyArray;

import java.util.*;

public class MyArray<E extends Comparable> implements MyList<E>, Iterable<E>  {
    private Object[] array;
    private boolean bubbleFlag;
    private int size;
    public MyArray() {
        array = new Object[10];
        size = 0;
        bubbleFlag = false;
    }

    public void bubbleSort() {
        if (size > 2 && !bubbleFlag) {
            E temp;
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (((E)array[i]).compareTo((E)array[j]) > 0) {
                        temp = (E)array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
            bubbleFlag = true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        array[size] = e;
        size++;
        if (array.length == size) {
            increase();
        }
        bubbleFlag = false;
        return true;
    }

    @Override
    public E get(int index) {
        if (index < size && index >= 0) {
            return (E) array[index];
        }
        return null;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (Object col: c) {
            this.add((E)col);
        }
        bubbleFlag = false;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean has = false;
        Object[] temp = new Object[array.length-1];
        for (int i = 0, j = 0; i < this.size() - 1; i++) {
            if (array[i].equals(o)) {
                has = true;
                continue;
            }
            temp[i] = array[j];
            j++;
        }
        size--;
        array = temp;
        bubbleFlag = false;
        return has;
    }

    private void increase() {
        Object[] temp = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return (E)array[index++];
        }
    }
}
