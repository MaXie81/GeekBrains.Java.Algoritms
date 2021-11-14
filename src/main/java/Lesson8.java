import java.util.Random;

public class Lesson8 {
    public static void main(String[] args) {
        int key;
        int removeKey = -1;
        Random random = new Random();

        ChainingHashMap<Integer, String> map = new ChainingHashMap<>(7);
        for (int i = 0; i < 7 ; i++) {
            key = random.nextInt(20);
            if (i == 0) removeKey = key;
            System.out.print(String.valueOf(key) + " ");
            map.put(key, "a");
        }
        System.out.println();
        System.out.println(map);

        map.remove(removeKey);
        System.out.println(removeKey);
        System.out.println(map);
    }
}