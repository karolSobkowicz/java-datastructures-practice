package list.linked;

import java.util.Objects;

/**
 * element = value of the current element being added.
 * prev = value of the previous element in the list.
 * next = value of the next element in the list.
 */

class LinkedElement<T> {
    T element;
    LinkedElement<T> prev;
    LinkedElement<T> next;

    LinkedElement(T element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedElement<?> that = (LinkedElement<?>) o;
        return element.equals(that.element) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, next);
    }
}
