package ss10_dsa_list.practice.simple_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(10);
        list.add(15);
        list.add(13);
        list.add(1);
        System.out.println("Element 2 " + list.get(2));
    }
}
