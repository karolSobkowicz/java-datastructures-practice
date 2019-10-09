package set;

// TODO Implement all methods
public class SimpleSet<T> {
    /**
     * Add an element if its not in the set already
     * if it is, do nothing
     * @param newItem item to be added
     */
    void add(T newItem) {
    }

    /**
     * Get the specified element from the set
     * @param index index of the element to return
     * @return the element at specified index
     * @throws IndexOutOfBoundsException if the index is < 0 or > than the size of the set
     */
    T get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Remove the element at index
     * @param index element to be removed
     * @throws IndexOutOfBoundsException if the index is < 0 or > than the size of the set
     */
    void remove(int index) throws IndexOutOfBoundsException {

    }

    /**
     * @return the number of elements in the set
     */
    int size() {
        return 0;
    }

    /**
     * @param element to be found
     * @return the index of the element, if found. or -1 if not
     */
    int indexOf(T element) {
        return 0;
    }
}
