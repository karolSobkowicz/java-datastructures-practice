package list.array;

import list.SimpleList;

/**
 * Created by Karol on 01/10/2019
 * Working array class with grow capability.
 */
public class ArraySimpleList<T> implements SimpleList<T> {

    private final int INITIAL_SIZE = 1000;
    private final int INCREMENT = 10; // times size

    @SuppressWarnings("unchecked")
    private T[] mainArray = (T[]) new Object[INITIAL_SIZE];
    private int size = 0;

    /**
     * Adds a single item to the array.
     * @param newItem is the new int value added to the array.
     */
    @Override
    public void add(T newItem) {
            mainArray[size] = newItem;
            size++;
            grow(size);
    }

    /**
     *
     * @param index specifies the location in the array.
     * @param newItem is the int value assigned to the index value.
     */
    @Override
    public void add(int index, T newItem) {
        checkBounds(index, true);
        mainArray[index] = newItem;
        size = Math.max(size, index + 1);
    }

    /**
     *
     * @param index specifies the location in the array.
     * @return the value assigned to the specified index.
     * @throws IndexOutOfBoundsException check.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        checkBounds(index, false);
        return mainArray[index];
    }

    /**
     * Removes item in specified location.
     * @param index specifies the location in the array.
     */
    @Override
    public void remove(int index){
        checkBounds(index, false);
        for(int i = index + 1; i < size; i++){
            mainArray[i-1] = mainArray[i];
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T element) {

        for (int i = 0; i <= size; i++) {
            T value = get(i);

            if (value.equals(element)) {
                return i;
            }
        }
        return -1;
    }



    /**
     * Checks if the specified index is within the size of the array.
     * @param index specifies the location in the array.
     */
    private void checkBounds(int index, boolean shouldGrow) {
        if (index < 0 || (index >= mainArray.length && !shouldGrow)) {
            throw new IndexOutOfBoundsException("The index entered is out of bounds. Please choose a different position in the array.");
        } else if (index >= mainArray.length) {
            grow(index);
        }
    }

    private void grow(int index) {
        if (index >= mainArray.length) {
            int newStorageSize = index * INCREMENT;
            @SuppressWarnings("unchecked")
            T[] tmpArray = (T[]) new Object[newStorageSize];
            System.arraycopy(mainArray, 0, tmpArray, 0, mainArray.length);
            mainArray = tmpArray;
        }
    }





}
