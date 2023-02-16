package co.edu.uptc.model.vector;

import co.edu.uptc.model.dinamic.UptcList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class UpctVector implements List {
    Object[] vector = {};

    @Override
    public int size() {
        return vector.length;
    }

    @Override
    public boolean isEmpty() {
        return vector.length > 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = vector[i];
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(Object e) {
        Object[] tmp = new Object[vector.length + 1];
        for (int i = 0; i < vector.length; i++) {
            tmp[i] = vector[i];
        }
        tmp[vector.length] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        vector = new Object[]{};
    }

    @Override
    public Object get(int index) {
        return vector[index];
    }

    @Override
    public Object set(int index, Object element) {
        vector[index] = element;
        return element;
    }

    @Override
    public void add(int index, Object element) {
        Object[] tmp = new Object[vector.length + 1];
        for (int i = 0; i < vector.length; i++) {
            if (i < index) {
                tmp[i] = vector[i];
            } else {
                tmp[i + 1] = vector[i];
            }
        }
        vector = tmp;
    }

    @Override
    public Object remove(int index) {

        return vector[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < vector.length; i++) {
            if (o.equals(vector[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < vector.length; i++) {
            if (o.equals(vector[i])) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        Object[] tmp = new Object[toIndex - fromIndex];
        for (int i = fromIndex; i <= toIndex; i++) {
            tmp[i - fromIndex] = vector[i];
        }
        return List.of(tmp);
    }

}