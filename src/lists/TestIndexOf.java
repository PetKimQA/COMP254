package lists;

public class TestIndexOf {
    public static void main(String[] args) {
        LinkedPositionalList<String> lst = new LinkedPositionalList<>();
        lst.addLast("A");
        Position<String> mid = lst.addLast("B");
        lst.addLast("C");

        System.out.println(lst.indexOf(mid));   // → 1
        System.out.println(lst.indexOf(null));  // → -1
    }
}
