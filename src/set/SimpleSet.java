package set;

import list.SimpleList;

/**
 * Created by Karol on 11/10/2019
 * Working Set class with grow capability.
 */
public class SimpleSet<T> implements SimpleList<T> {

    private final int INITIAL_SIZE = 1000;
    private final int INCREMENT = 10; // times size

    @SuppressWarnings("unchecked")
    private T[] mainArray = (T[]) new Object[INITIAL_SIZE];
    private int size = 0;

    /**
     * Add an element if its not in the set already
     * if it is, do nothing
     * @param newItem item to be added
     */
    public void add(T newItem) {
        if (checkUnique(newItem)) {
            mainArray[size] = newItem;
            size++;
            grow(size);
        } else {
            System.out.println("Cannot add element: " + newItem + " as it violates the rules of a set. Each element must be unique!");
        }
    }

    /**
     * Add an element if its not in the set already
     * if it is, do nothing
     * @param index specifies the position in the list where you want to add an element.
     * @param newItem item to be added.
     */
    @Override
    public void add(int index, T newItem) {
        if (checkUnique(newItem)) {
            checkBounds(index, true);
            mainArray[index] = newItem;
            size = Math.max(size, index + 1);
        } else {
            System.out.println("Cannot add element: " + newItem + " as it violates the rules of a set. Each element must be unique!");
        }
    }

    /**
     * Get the specified element from the set
     * @param index index of the element to return
     * @return the element at specified index
     * @throws IndexOutOfBoundsException if the index is < 0 or > than the size of the set
     */
    public T get(int index) throws IndexOutOfBoundsException {
        checkBounds(index, false);
        return mainArray[index];
    }

    /**
     * Remove the element at index
     * @param index element to be removed
     * @throws IndexOutOfBoundsException if the index is < 0 or > than the size of the set
     */
    public void remove(int index) {
        checkBounds(index, false);
        for(int i = index + 1; i < size; i++){
            mainArray[i-1] = mainArray[i];
        }
        size--;
    }

    /**
     * @return the number of elements in the set
     */
    public int size() {
        return size;
    }

    /**
     * @param newItem to be found
     * @return the index of the newItem, if found. or -1 if not
     */
    public int indexOf(T newItem) {
        for (int i = 0; i <= size; i++) {
            T value = get(i);

            if (value.equals(newItem)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Check if suggested index is within the current size of the array.
     * @param index specifies the position in the array you want to change.
     * @param shouldGrow boolean value dependent on current size of the array.
     */
    private void checkBounds(int index, boolean shouldGrow) {
        if (index < 0 || (index >= mainArray.length && !shouldGrow)) {
            throw new IndexOutOfBoundsException("The index entered is out of bounds. Please choose a different position in the array.");
        } else if (index >= mainArray.length) {
            grow(index);
        }
    }

    /**
     * Grow array if index is out of original size.
     * @param index specifies by how much the array should grow.
     */
    private void grow(int index) {
        if (index >= mainArray.length) {
            int newStorageSize = index * INCREMENT;
            @SuppressWarnings("unchecked")
            T[] tmpArray = (T[]) new Object[newStorageSize];
            System.arraycopy(mainArray, 0, tmpArray, 0, mainArray.length);
            mainArray = tmpArray;
        }
    }

    /**
     * Checks if the suggested newItem value is already in the array.
     * If not, then it will return true. Otherwise it will return false.
     * @param newItem Value of
     * @return true or false if value is unique or not.
     */
    private boolean checkUnique (T newItem) {
        boolean result = true;

        if (size == 0){
            result = true;
        } else {
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(newItem)) {
                    result = false;
                }
            }
        } return result;
    }



}
