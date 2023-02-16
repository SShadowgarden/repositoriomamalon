package co.edu.uptc.model.dinamic;

import co.edu.uptc.model.NodeClass;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UptcList implements List {

    private NodeClass header;
    private int size;


    public UptcList() {
        header = null;
        size = 0;
    }

    @Override
    public int size() {
        int count = 0;
        while (getNode(count) != null) count++;
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] toArray = new Object[size];
        for (int i = 0; i < size; i++) {
            toArray[i] = getNode(i).getValue();
        }
        return toArray;
    }

    @Override
    public boolean add(Object object) {
        if (header == null) {
            header = new NodeClass(object);
        } else {
            getNode(size - 1).setNext(new NodeClass(object));
        }
        size = size();
        return false;
    }

    private NodeClass getNode(int index) {
        NodeClass temp = header;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        header = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        NodeClass toReturn = getNode(index);
        if (index == 0) {
            header = new NodeClass(element, toReturn.getNext());
        } else if (index == size - 1) {
            getNode(size - 2).setNext(new NodeClass(element));
        } else {
            getNode(size - 2).setNext(new NodeClass(element, toReturn.getNext()));
        }
        return toReturn.getValue();
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        if (index == 0) header = new NodeClass(element, header);
        else getNode(index - 1).setNext(new NodeClass(element, getNode(index)));
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        NodeClass toReturn = getNode(index);
        if (index == 0) header = toReturn.getNext();
        else if (index == size - 1) getNode(index - 1).setNext(null);
        else getNode(index - 1).setNext(toReturn.getNext());
        size = size();
        return toReturn.getValue();
    }

    @Override
    public boolean remove(Object object) {
        if (contains(object)) {
            remove(indexOf(object));
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).getValue().equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int toReturn = -1;
        for (int i = 0; i < size; i++) {
            if (getNode(i).getValue().equals(object)) {
                toReturn = i;
            }
        }
        return toReturn;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        Object[] subList = new Object[toIndex - fromIndex];
        for (int i = fromIndex; i < toIndex; i++) {
            subList[i-fromIndex] = getNode(i);
        }
        return List.of(subList);
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] aux = new Object[a.length];
        for (int i = 0; i < size; i++) {
            aux[i] = getNode(i);
        }
        if (a.length > size) {
            for (int i = size; i < a.length; i++) {
                aux[i] = null;
            }
        }
        return aux;
    }
}
