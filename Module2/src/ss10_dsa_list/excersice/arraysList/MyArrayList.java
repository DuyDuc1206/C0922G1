package ss10_dsa_list.excersice.arraysList;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity " + capacity);
        }
    }

    // method increase the size of the array
    public void ensureCapa(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("Min Capacity " + minCapacity);
        }
    }

    // add one element in array
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapa(10);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapa(10);
            elements[index] = element;
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }

    }

    public int getSize() {
        return this.size;
    }

    // Method clear elements of array
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    //    clone
    public MyArrayList<E> clone() {
        MyArrayList<E> v = new MyArrayList<>();
        v.elements = Arrays.copyOf(this.elements, this.size);
        v.size = this.size;
        return v;
    }
    public E remove( int index){
        if(index<0 ||index>size){
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i <size-1 ; i++) {
            elements[i] = elements[i-1];
        }
        elements[size-1] =null;
        size--;
        return element;
    }
}
