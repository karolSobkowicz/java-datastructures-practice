package set;

import list.SimpleList;
import list.array.ArraySimpleList;
import org.junit.jupiter.api.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSetTest {

    @Test
    void add() {
        SimpleSet<Integer> myNewArray = new SimpleSet<>();

        myNewArray.add(2); // should check the checkUnique method.
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
//        assertThrows(IndexOutOfBoundsException.class, () -> {
//            assertEquals(4, myNewArray.get(2));
//        });
    }

    @Test
    void get() {
        SimpleSet<Integer> myNewArray = new SimpleSet<Integer>();

        myNewArray.add(2);
        myNewArray.add(4);

        assertEquals(2, myNewArray.get(0));
        assertEquals(4, myNewArray.get(1));
        assertEquals(2, myNewArray.size());
    }

    @Test
    void remove() {
        SimpleSet<Integer> myNewArray = new SimpleSet<>();

        myNewArray.add(2);
        myNewArray.add(4);
        myNewArray.add(5);
        myNewArray.add(6);
        myNewArray.add(8);

        myNewArray.remove(2);

        assertEquals(4, myNewArray.size());
    }

    @Test
    void size() {
        SimpleSet<Integer> myNewArray = new SimpleSet<>();

        myNewArray.add(2);
        myNewArray.add(3);
        myNewArray.add(5);
        myNewArray.add(7);
        myNewArray.add(9);

        assertEquals(5, myNewArray.size());
    }

    @Test
    void indexOf() {
        SimpleSet<Integer> myNewArray = new SimpleSet<Integer>();

        myNewArray.add(2);
        myNewArray.add(3);
        myNewArray.add(5);

        assertEquals(3, myNewArray.size());

        assertEquals(0, myNewArray.indexOf(2));
        assertEquals(2, myNewArray.indexOf(5));
    }

    @Test
    void checkUnique() {
        SimpleSet<Integer> myNewArray = new SimpleSet<Integer>();

        myNewArray.add(2); // should check the checkUnique method.
        myNewArray.add(4);
        myNewArray.add(4);

        assertEquals(2, myNewArray.get(0));
        assertEquals(4, myNewArray.get(1));
        assertEquals(2, myNewArray.size());
    }



}