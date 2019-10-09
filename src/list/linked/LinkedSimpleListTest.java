package list.linked;

import list.SimpleList;
import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkedSimpleListTest {

    @org.junit.jupiter.api.Test
    void add() {
        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();

        myNewArray.add(2);
        myNewArray.add(4);

        Assertions.assertEquals(2, myNewArray.get(0));
        Assertions.assertEquals(4, myNewArray.get(1));
        Assertions.assertEquals(2, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void addInitialBiggerThanSize() {
        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();
        myNewArray.add(10000, 1);

        Assertions.assertEquals(1, myNewArray.get(10000));
        Assertions.assertEquals(10000 + 1, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void addMany() {
        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();
        int size = 1000;

        for (int i = 0; i < size; i++) {
            myNewArray.add(i);
        }

        Assertions.assertEquals(999, myNewArray.get(999));
        Assertions.assertEquals(size, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();
        myNewArray.add(2);                          // 2, 4, 6
        myNewArray.add(4);
        myNewArray.add(6);


        myNewArray.add(1, 10);      // 2, 10, 4, 6
        myNewArray.add(2, 5);       // 2, 10, 5, 4, 6

        Assertions.assertEquals(2, myNewArray.get(0));
        Assertions.assertEquals(5, myNewArray.get(2));
        Assertions.assertEquals(5, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void getOnEmptyList() {
        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Assertions.assertEquals(0, myNewArray.get(0));
        });

        Assertions.assertEquals(0, myNewArray.size());
    }


    @org.junit.jupiter.api.Test
    void removeMidElement() {

        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();
        myNewArray.add(2);
        myNewArray.add(4);
        myNewArray.add(6);

        Assertions.assertEquals(3, myNewArray.size());

        myNewArray.remove(1);
        Assertions.assertEquals(6, myNewArray.get(1));
        Assertions.assertEquals(2, myNewArray.size());

    }

    @org.junit.jupiter.api.Test
    void removeLastElement() {

        SimpleList<Integer> myNewArray = new LinkedSimpleList<>();
        myNewArray.add(2);
        myNewArray.add(4);

        Assertions.assertEquals(2, myNewArray.size());

        myNewArray.remove(myNewArray.size() - 1);
        Assertions.assertEquals(2, myNewArray.get(0));
        Assertions.assertEquals(1, myNewArray.size());

    }

    @org.junit.jupiter.api.Test
    void removeFirstElement() {

        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();
        myNewArray.add(2);
        myNewArray.add(4);

        Assertions.assertEquals(2, myNewArray.size());

        myNewArray.remove(1);
        Assertions.assertEquals(2, myNewArray.get(0));
        Assertions.assertEquals(1, myNewArray.size());
    }

    @org.junit.jupiter.api.Test
    void indexOf() {

        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();
        myNewArray.add(1);
        myNewArray.add(2);
        myNewArray.add(4);
        myNewArray.add(3);
        myNewArray.add(4);

        Assertions.assertEquals(5, myNewArray.size());

        Assertions.assertEquals(1, myNewArray.indexOf(2));
        Assertions.assertEquals(-1, myNewArray.indexOf(5));

        Assertions.assertEquals(2, myNewArray.indexOf(4));
        Assertions.assertEquals(3, myNewArray.indexOf(3));
    }

    @org.junit.jupiter.api.Test
    void checkoutofBounds() {

        SimpleList<Integer> myNewArray = new LinkedSimpleList<Integer>();

        assertThrows(IndexOutOfBoundsException.class, () -> {   // lambda
            myNewArray.get(-1);
        });
    }

}