package list.array;

import list.SimpleList;
import list.linked.LinkedSimpleList;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ArraySimpleListTest {

    @org.junit.jupiter.api.Test
    void add() {
        SimpleList<Integer> myNewArray = new ArraySimpleList<>();

        myNewArray.add(2);
        myNewArray.add(4);

        assertEquals(2, myNewArray.get(0));
        assertEquals(4, myNewArray.get(1));
        assertEquals(2, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void addInitialBiggerThanSize() {
        SimpleList<Integer> myNewArray = new ArraySimpleList<>();
        myNewArray.add(10000, 1);

        assertEquals(1, myNewArray.get(10000));
        assertEquals(10000 + 1, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void addMany() {
        SimpleList<Integer> myNewArray = new ArraySimpleList<>();
        int size = 1000000;

        for (int i = 0; i < size; i++) {
            myNewArray.add(i);
        }

        assertEquals(999, myNewArray.get(999));
        assertEquals(size, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        SimpleList<Integer> myNewArray = new ArraySimpleList<>();
        myNewArray.add(5, 10);

        assertNull(myNewArray.get(0));
        assertEquals(10, myNewArray.get(5));
        assertEquals(6, myNewArray.size());
    }


    @org.junit.jupiter.api.Test
    void removeMidElement() {

        SimpleList<Integer> myNewArray = new ArraySimpleList<>();
        myNewArray.add(2);
        myNewArray.add(4);
        myNewArray.add(6);

        assertEquals(3, myNewArray.size());

        myNewArray.remove(1);
        assertEquals(6, myNewArray.get(1));
        assertEquals(2, myNewArray.size());

    }

    @org.junit.jupiter.api.Test
    void removeFirstElement() {

        SimpleList<Integer> myNewArray = new ArraySimpleList<>();
        myNewArray.add(2);
        myNewArray.add(4);

        assertEquals(2, myNewArray.size());

        myNewArray.remove(0);
        assertEquals(4, myNewArray.get(0));
        assertEquals(1, myNewArray.size());

    }

    @org.junit.jupiter.api.Test
    void removeLastElement() {

        SimpleList<Integer> myNewArray = new ArraySimpleList<>();
        myNewArray.add(2);
        myNewArray.add(4);

        assertEquals(2, myNewArray.size());

        myNewArray.remove(1);
        assertEquals(2, myNewArray.get(0));
        assertEquals(1, myNewArray.size());


    }

    @org.junit.jupiter.api.Test
    void indexOf() {

        SimpleList<Integer> myNewArray = new ArraySimpleList<>();
        myNewArray.add(2);
        myNewArray.add(4);
        myNewArray.add(6);
        myNewArray.add(3);
        myNewArray.add(2);
        myNewArray.add(12);

        Assertions.assertEquals(6, myNewArray.size());

        Assertions.assertEquals(0, myNewArray.indexOf(2));
        System.out.println("The answer for this should be 0 : Ans = " + myNewArray.indexOf(2));
        Assertions.assertEquals(1, myNewArray.indexOf(4));
        System.out.println("The answer for this should be 1 : Ans = " + myNewArray.indexOf(4));
        Assertions.assertEquals(-1, myNewArray.indexOf(124));
        System.out.println("The answer for this should be -1 : Ans = " + myNewArray.indexOf(124));
    }

    @org.junit.jupiter.api.Test
    void checkoutofBounds() {

        SimpleList<Integer> myNewArray = new ArraySimpleList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {   // lambda
            myNewArray.get(-1);
        });
    }

}