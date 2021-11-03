import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson5 {
    static List<Item> itemDictionaryList = new ArrayList<>();
    static List<Item> itemList = new ArrayList<>();
    static Box box;
    static int index = -1;
    static int maxCostSum = 0;
    static {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            itemDictionaryList.add(new Item("Предмет №" + i, random.nextInt(10) + 1, random.nextInt(10) + 1));
        }
    }

    public static void main(String[] args) throws Exception {
        box = new Box(25);
        System.out.println(itemDictionaryList);

        packItemList(itemList, 0, 0);
        printResult(box.getItemList());
    }
    static boolean packItemList(List<Item> sumList, int sumVolume, int sumCost) {
        ++index;
        if (index >= itemDictionaryList.size()) return true;
        for (int i = 0; i <= 1; i++) {
            itemList = new ArrayList<>(sumList);
            if (i == 1) {
                itemList.add(itemDictionaryList.get(index));
                sumVolume += itemDictionaryList.get(index).VOLUME;
                sumCost += itemDictionaryList.get(index).COST;
                if (sumVolume > box.MAX_VOLUME) return true;
            }
            if (packItemList(itemList, sumVolume, sumCost))
                if (sumCost > maxCostSum) {
                    maxCostSum = sumCost;
                    box.setItemList(itemList);
                }
            index--;
        }
        return false;
    }
    static void printResult(List<Item> list) {
        System.out.print(list);
        int volume = 0;
        int cost = 0;

        for (Item item : list) {
            volume += item.VOLUME;
            cost += item.COST;
        }
        System.out.println(": " + volume + '/' + cost);
    }
}
