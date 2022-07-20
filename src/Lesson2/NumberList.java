package Lesson2;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.round;

public class NumberList<T extends Number> implements List<T> {

    private static int initialSize = 3;
    private static int fillFactor = 40; // Процент наполненности пустыми элементами, когда уже нужно пересоздание

    private T[] array;
    private int size;
    private int emptyCount;
    private Class<T> clazz;

    public NumberList(Class<T> clazz) {
        this.clazz = clazz;
        this.array = (T[]) Array.newInstance(clazz, initialSize);
    }
    private void defragOnDemand() {
        if (size == 0) {
            return;
        }

        if ((double) emptyCount / size * 100 < fillFactor) {
            return;
        }

        int realCount = 0;
        for (T t : array) {
            if (t != null) {
                realCount++;
            }
        }
        T[] newArray = (T[]) Array.newInstance(clazz, realCount);
        int currentIndex = 0;
        for (T t : array) {
            if (t == null) {
                continue;
            }
            newArray[currentIndex] = t;
            currentIndex++;
        }
        emptyCount = 0;
        array = newArray;
    }

    public double getDouble(int index) {
        int offset=array.length-size;
        T element=array[index+offset];
        if (element instanceof Double) {
            return (double)element;
        }
        throw new RuntimeException("Получаемый элемент не является типом Double");
    }

    public int sumIntegers() {
        int result=0;

        for (T t : array) {
            if (!(t instanceof Integer)) {
                throw new RuntimeException("Один из элементов списка не является типом Integer");
            }
            result=result+(int)t;
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        int matchCount=0;
        for (T t : array) {
            if (t==null){
                continue;
            }
            if (t.equals(o)) {
                matchCount++;
                if (matchCount>=2){
                    return true;
                }
            }
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
        if (size >= array.length) {
            T[] newArray = (T[]) Array.newInstance(clazz, (int) round(array.length * 1.5));
            int newArrayIndex = newArray.length;
            for (int i = array.length; i > 0; i--) {
                if (array[i-1] == null) {
                    continue;
                }
                newArray[newArrayIndex-1] = array[i-1];
                newArrayIndex--;
            }
            array=newArray;
        }
        int insertIndex=array.length-size-1;
        array[insertIndex] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean Result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            if (!array[i].equals(o)) {
                continue;
            }
            array[i] = null;
            emptyCount++;
            Result = true;
        }
        if (Result) {
            defragOnDemand();
        }
        return Result;
    }

    public void remove() {
        this.size=0;
        this.emptyCount=0;
        this.array = (T[]) Array.newInstance(clazz, initialSize);
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
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
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

    @Override
    public String toString() {
        if (isEmpty()){
            return "NumberList is empty";
        }
        String result = "";
        for (T t : array) {
            if (t != null) {
                result += t.toString() + " ";
            }
        }


        return "NumberList{" +
                "array=" + result +
                '}';
    }
}
