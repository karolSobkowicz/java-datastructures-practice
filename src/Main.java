import list.SimpleList;
import list.array.ArraySimpleList;

public class Main {

    public static void main(String[] args) {

        SimpleList<Integer> myNewArray = new ArraySimpleList<>();

        myNewArray.add(2);
        myNewArray.add(4);

        Main.listCounter(myNewArray);

    }

    public static void listCounter(SimpleList simpleList) {
        System.out.println(simpleList.size());
    }
}
