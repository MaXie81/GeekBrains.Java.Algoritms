package graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public final int POINT_COUNT;
    private int linkCount;
    private LinkedList<Integer>[] linkList;
    private boolean[] isSorted;

    public Graph(int pointCount) {
        this.POINT_COUNT = pointCount;
        linkList = new LinkedList[POINT_COUNT];
        isSorted = new boolean[POINT_COUNT];
        for (int i = 0; i < linkList.length; i++) {
            linkList[i] = new LinkedList<>();
        }
    }
    public void setLink(Integer fromPoint, Integer toPoint) {
        if (fromPoint < 0 || fromPoint >= POINT_COUNT) throw new IllegalArgumentException("fromPoint: " + fromPoint);
        if (toPoint < 0 || toPoint >= POINT_COUNT) throw new IllegalArgumentException("toPoint: " + toPoint);
        linkList[fromPoint].add(toPoint);
        isSorted[fromPoint] = false;
        if (fromPoint != toPoint) {
            linkList[toPoint].add(fromPoint);
            isSorted[toPoint] = false;
        }
        ++linkCount;
    }
    public List<Integer> getLinkList(int point) {
        if (!isSorted[point]) {
            Collections.sort(linkList[point]);
            isSorted[point] = true;
        }
        return linkList[point];
    }
}
