/*
 * В Коллекции реализованы следующие методы: int size(), boolean isEmpty(),
 * boolean add(E), E get(int), boolean contains(Object), boolead addAll(Collection),
 * boolean remove(Object).
 *
 * Реализована сортировка пузырьком по алфавиту для строк, по возростанию для чисел
 * и по возростанию хэшкода для остальных объектов. Имеется флаг для проверки, отсортирован
 * список иои нет.
 */

package com.myproject.www;

import java.util.*;

public class MyArray<E> implements List<E>  {
    private Object[] array;
    private boolean bubbleFlag;
    private int size;
    Comparator<? extends E> comparator = new Comparator<E>() {
        @Override
        public int compare(E o1, E o2) {
            return 0;
        }
    };
    public MyArray() {
        array = new Object[10];
        size = 0;
        bubbleFlag = false;
    }

    public void bubbleSort() {
        if (size > 2 && !bubbleFlag) {
            if ((E)array[0] instanceof String) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        String s1 = array[i].toString();
                        String s2 = array[j].toString();
                        if (s1.compareTo(s2) > 0) {
                            array[i] = s2;
                            array[j] = s1;
                        }
                    }
                }
            } else if ((E)array[0] instanceof Byte) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        byte l1 = (byte)array[i];
                        byte l2 = (byte)array[j];
                        if (l1 > l2) {
                            array[i] = l2;
                            array[j] = l1;
                        }
                    }
                }
            }  else if ((E)array[0] instanceof Short) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        short l1 = (short)array[i];
                        short l2 = (short)array[j];
                        if (l1 > l2) {
                            array[i] = l2;
                            array[j] = l1;
                        }
                    }
                }
            } else if ((E)array[0] instanceof Integer) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        int l1 = (int)array[i];
                        int l2 = (int)array[j];
                        if (l1 > l2) {
                            array[i] = l2;
                            array[j] = l1;
                        }
                    }
                }
            } else if ((E)array[0] instanceof Long) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        long l1 = (long)array[i];
                        long l2 = (long)array[j];
                        if (l1 > l2) {
                            array[i] = l2;
                            array[j] = l1;
                        }
                    }
                }
            } else if ((E)array[0] instanceof Character) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        char l1 = (char)array[i];
                        char l2 = (char)array[j];
                        if (l1 > l2) {
                            array[i] = l2;
                            array[j] = l1;
                        }
                    }
                }
            } else if ((E)array[0] instanceof Float) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        float l1 = (float)array[i];
                        float l2 = (float)array[j];
                        if (l1 > l2) {
                            array[i] = l2;
                            array[j] = l1;
                        }
                    }
                }
            } else if ((E)array[0] instanceof Double) {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        double l1 = (double)array[i];
                        double l2 = (double)array[j];
                        if (l1 > l2) {
                            array[i] = l2;
                            array[j] = l1;
                        }
                    }
                }
            } else {
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        Object l1 = array[i];
                        Object l2 = array[j];
                        if (l1.hashCode() > l2.hashCode()) {
                            array[i] = l2;
                            array[j] = l1;
                        }
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
        return false;
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

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
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
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
    private void increase() {
        Object[] temp = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}
