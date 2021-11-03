import java.util.ArrayList;
import java.util.List;

public class Box {
    public final int MAX_VOLUME;
    private List<Item> itemList;

    public Box(int MAX_VOLUME) {
        this.MAX_VOLUME = MAX_VOLUME;
    }

    public void setItemList(List<Item> itemList) {this.itemList = new ArrayList<>(itemList);}
    public List<Item> getItemList() {return itemList;}
}
