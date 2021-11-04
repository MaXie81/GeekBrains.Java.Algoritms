import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson5 {
    public static void main(String[] args) throws Exception {
        Itarate itarate = new Itarate();

        // п.1
        System.out.println(itarate.multiply(4, 2));
        System.out.println(itarate.multiply(3, 1));
        System.out.println(itarate.multiply(3, 3));

        // п.2
        Box box = new Box(25);

        List<Item> availableItemList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            availableItemList.add(new Item("Предмет №" + i, random.nextInt(10) + 1, random.nextInt(10) + 1));
        }
        System.out.println(availableItemList);

        box.setItemList(itarate.getPackItemList(availableItemList, box.MAX_VOLUME));
        itarate.printResult(box.getItemList());
    }
}
