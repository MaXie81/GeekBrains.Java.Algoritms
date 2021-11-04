import java.util.ArrayList;
import java.util.List;

public class Itarate {
    private List<Item> availableItemList;
    private List<Item> currentItemList;
    private List<Item> packItemList;
    private int maxVolume;
    private int index = -1;
    private int maxCostSum = 0;

    public long multiply(int number, int extent) {
        if (extent > 1) return multiply(number, extent - 1) * number;
        return number;
    }

    public List<Item> getPackItemList(List<Item> availableItemList, int volume) {
        currentItemList = new ArrayList<>();
        packItemList = new ArrayList<>();

        this.availableItemList = availableItemList;
        this.maxVolume = volume;

        packAvailableItemList(currentItemList, 0, 0);
        return packItemList;
    }
    private boolean packAvailableItemList(List<Item> sumList, int sumVolume, int sumCost) {
        ++index;
        if (index >= availableItemList.size()) return true;
        for (int i = 0; i <= 1; i++) {
            currentItemList = new ArrayList<>(sumList);
            if (i == 1) {
                currentItemList.add(availableItemList.get(index));
                sumVolume += availableItemList.get(index).VOLUME;
                sumCost += availableItemList.get(index).COST;
                if (sumVolume > maxVolume) return true;
            }
            if (packAvailableItemList(currentItemList, sumVolume, sumCost))
                if (sumCost > maxCostSum) {
                    maxCostSum = sumCost;
                    packItemList = currentItemList;
                }
            index--;
        }
        return false;
    }
    public void printResult(List<Item> list) {
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
