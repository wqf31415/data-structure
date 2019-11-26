public class Main {

    public static void main(String[] args) {

        Array array = new Array();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addFirst(4);
        System.out.println(array);

        array.add(1,5);
        System.out.println(array);

        System.out.println(array.get(2));
    }
}
