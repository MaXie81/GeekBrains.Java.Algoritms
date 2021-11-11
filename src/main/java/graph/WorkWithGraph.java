package graph;

import graph.Graph;

public abstract class WorkWithGraph {
    protected Graph graph;
    public final int START_POINT;
    protected Integer[] mapFromPoint;
    protected boolean[] isVisited;

    public WorkWithGraph(Graph graph, Integer startPoint) {
        this.graph = graph;
        this.START_POINT = startPoint;
        mapFromPoint = new Integer[graph.POINT_COUNT];
        isVisited = new boolean[graph.POINT_COUNT];
        completeGraph(startPoint);
    }

    abstract void completeGraph(Integer fromPoint);

    public Integer[] getMapFromPoint() {
        return mapFromPoint;
    }

    public boolean isPath(Integer toPoint) {
        return isVisited[toPoint];
    }
}
