package list;


/**
 * Created by Karol on 02/10/2019
 *  Interface with methods which are applicable to all associated lists.
 * @param <T> is a generic type.
 */
public interface SimpleList<T> {
    void add(T newItem);
    void add(int index, T newItem);
    T get(int index) throws IndexOutOfBoundsException;
    void remove(int index) throws IndexOutOfBoundsException;
    int size();
    int indexOf(T element);
}
