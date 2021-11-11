package graph;

public class DepthFirstSearch extends WorkWithGraph {
    public DepthFirstSearch(Graph graph, Integer startPoint) {
        super(graph, startPoint);
    }

    @Override
    void completeGraph(Integer fromPoint) {
        isVisited[fromPoint] = true;
        for (Integer toPoint : graph.getLinkList(fromPoint)) {
            if (isVisited[toPoint]) continue;
            mapFromPoint[toPoint] = fromPoint;
            completeGraph(toPoint);
        }
    }
}
