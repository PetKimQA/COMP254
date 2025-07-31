package exercise02;

public class TableMapTest {
    public static void main(String[] args) {
        CustomSortedTableMap<String, String> map = new CustomSortedTableMap<>();

        map.put("apple", "red");
        map.put("banana", "yellow");
        map.put("cherry", null);  // test null value

        System.out.println("Contains 'apple'? " + map.containsKey("apple"));   // true
        System.out.println("Contains 'banana'? " + map.containsKey("banana")); // true
        System.out.println("Contains 'cherry'? " + map.containsKey("cherry")); // true
        System.out.println("Contains 'date'? " + map.containsKey("date"));     // false

        System.out.println("Get 'cherry': " + map.get("cherry"));              // null (exists)
        System.out.println("Get 'date': " + map.get("date"));                  // null (not exists)
    }
}
