package com.myproject.www.MyArray;

import java.util.Collection;

public interface MyList<E> {
    int size();
    boolean isEmpty();
    boolean add(E e);
    E get(int index);
    boolean contains(Object o);
    boolean addAll(Collection<? extends E> c);
    boolean remove(Object o);
}
