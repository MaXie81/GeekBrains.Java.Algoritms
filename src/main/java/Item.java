public class Item {
    public final String NAME;
    public final int VOLUME;
    public final int COST;

    public Item(String NAME, int VOLUME, int COST) {
        this.NAME = NAME;
        this.VOLUME = VOLUME;
        this.COST = COST;
    }

    @Override
    public String toString() {
        return '(' + NAME + ": " + VOLUME + '/' + COST + ')';
    }
}