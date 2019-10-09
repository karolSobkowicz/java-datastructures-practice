package list.linked;

import list.SimpleList;
import sun.awt.image.ImageWatched;

import java.sql.SQLOutput;
import java.util.Objects;

public class LinkedSimpleList<T> implements SimpleList<T> {

    private LinkedElement<T> firstElement;
    private int size = 0;



    @Override
    public void add(T newItem) {
        // Here you create a temporary element.
        LinkedElement<T> tmpElement = new LinkedElement<>(newItem);

        if (firstElement == null) {
            firstElement = tmpElement;
            size = 1;
        } else {
            LinkedElement<T> currentElement = firstElement;
            while (currentElement.next != null) {
                currentElement = currentElement.next;
            }
            // currentElement is the last element in the list, now. Meaning that currentElement.next is null.
            currentElement.next = tmpElement; // These two are pointing at each other now.
            tmpElement.prev = currentElement;
            size++;
        }
    }

    @Override
    public void add(int index, T newItem) {

        LinkedElement<T> tmpElement = new LinkedElement<T>(newItem);
        LinkedElement<T> currentElement = firstElement;

        // When we add an element to the middle of the list.
        if ((getLinkedElement(index) != null) && (getLinkedElement(index).next != null) && (getLinkedElement(index).prev != null)) {
            currentElement = getLinkedElement(index);
            currentElement.prev.next = tmpElement;
            currentElement.prev = tmpElement;
            tmpElement.next = currentElement;
        } else if (index >= size) {
            currentElement = getLinkedElement(size -1); //this will start the iteration from the last element in the list.
            while (index > size){
                currentElement.next = new LinkedElement<>(null);
                currentElement = currentElement.next;
                size++;
            }
            currentElement.next = tmpElement;
            tmpElement.prev = currentElement;
            tmpElement.next = null;
            size++;

        } else if (getLinkedElement(index).prev == null) {
            currentElement.prev = tmpElement;
            tmpElement.next = currentElement;
            tmpElement.prev = null;
            size++;

        } else if (getLinkedElement(index).next == null) {
            currentElement.prev.next = tmpElement;
            tmpElement.next = currentElement;
            currentElement.prev = tmpElement;
            size++;

        }




    }


    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        LinkedElement<T> currentElement = getLinkedElement(index);
        return currentElement.element;
    }

    @Override
    public void remove(int index) {
        LinkedElement<T> currentElement = getLinkedElement(index);

        if (currentElement.prev != null && currentElement.next != null) {
            currentElement.next.prev = currentElement.prev;
            currentElement.prev.next = currentElement.next;
        } else if (currentElement.prev == null) {
            currentElement.next.prev = null;
            firstElement = currentElement.next;
        } else if (currentElement.next == null) {
            currentElement.prev.next = null;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }


    public int indexOf(T element) {
        int curIndex = 0;
        LinkedElement<T> currentElement = firstElement;
        if (currentElement == null){
            return -1;
        }

        while (currentElement.next != null) {
            currentElement = currentElement.next;

            if (currentElement.element.equals(element)) {
                return curIndex;
            }

            curIndex++;
        }

        return -1;
    }

    private LinkedElement<T> getLinkedElement(int index) throws IndexOutOfBoundsException{
        int curIndex = 0;
        LinkedElement<T> currentElement = firstElement;
        if (currentElement == null){
            throw new IndexOutOfBoundsException("The list is empty - no elements to get.");
        }

        while (currentElement.next != null && curIndex < index){
            currentElement = currentElement.next;
            curIndex++;
        }
        if (curIndex != index) {
            // index out of bounds (too big)
            throw new IndexOutOfBoundsException("Index out of bounds (too big)");
        }
        return currentElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedSimpleList<?> that = (LinkedSimpleList<?>) o;
        return size == that.size &&
                firstElement.equals(that.firstElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElement);
    }
}
