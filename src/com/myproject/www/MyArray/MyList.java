package com.myproject.www.MyArray;

import java.util.Collection;
import java.util.List;

public interface MyList<E> {
    public int size();
    public boolean isEmpty();
    public boolean add(E e);
    public E get(int index);
    public boolean contains(Object o);
    public boolean addAll(Collection<? extends E> c);
    public boolean remove(Object o);
}
