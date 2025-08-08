package exercise1;


/**
 * ex1 demo
 * */
public class Exercise1Demo {
    public static void main(String[] args) {
        IterativeTreeMap<Integer, String> map = new IterativeTreeMap<>();
        //adding test data
        map.put(50, "A");
        map.put(30, "B");
        map.put(70, "C");
        map.put(20, "D");
        map.put(40, "E");
        map.put(60, "F");
        map.put(80, "G");

        System.out.println("Map size: " + map.size());
        System.out.println("Get 40 -> " + map.get(40));  // existing one in the tree
        System.out.println("Get 25 -> " + map.get(25));  // getting something doesn't exist in the tree
        map.remove(30);
        System.out.println("Checking after removing 30 -> " + map.get(30));
        System.out.println("Min: " + map.firstEntry().getKey()
                + ", Max: " + map.lastEntry().getKey());
    }
}
