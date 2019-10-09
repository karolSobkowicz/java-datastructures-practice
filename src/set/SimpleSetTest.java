package set;

import list.SimpleList;
import list.array.ArraySimpleList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSetTest {

    @Test
    void add() {
        SimpleSet<Integer> myNewArray = new SimpleSet<>();

        myNewArray.add(2);
        myNewArray.add(4);

        assertEquals(2, myNewArray.get(0));
        assertEquals(4, myNewArray.get(1));
        assertEquals(2, myNewArray.size());
    }

    @Test
    void addDuplicates() {
        SimpleSet<Integer> myNewArray = new SimpleSet<>();

        myNewArray.add(2);
        myNewArray.add(4);
        myNewArray.add(2);

        assertEquals(2, myNewArray.get(0));
        assertEquals(4, myNewArray.get(1));
        assertEquals(2, myNewArray.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            assertEquals(4, myNewArray.get(2));
        });
    }

    @Test
    void get() {
        SimpleSet<Integer> myNewArray = new SimpleSet<>();

        myNewArray.add(2);
        myNewArray.add(4);

        assertEquals(2, myNewArray.get(0));
        assertEquals(4, myNewArray.get(1));
    }

    @Test
    void remove() {
    }

    @Test
    void size() {
    }

    @Test
    void indexOf() {
    }
}