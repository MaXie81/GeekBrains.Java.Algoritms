package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstSearch extends WorkWithGraph {
    public BreadthFirstSearch(Graph graph, Integer startPoint) {
        super(graph, startPoint);
    }

    @Override
    void completeGraph(Integer fromPoint) {
        isVisited[fromPoint] = true;
        LinkedList<Integer> queue = new LinkedList<>(Arrays.asList(fromPoint));

        while (!queue.isEmpty()) {
            fromPoint = queue.pollFirst();

            for (Integer toPoint : graph.getLinkList(fromPoint)) {
                if (isVisited[toPoint]) continue;
                mapFromPoint[toPoint] = fromPoint;
                isVisited[toPoint] = true;
                queue.add(toPoint);
            }
        }
    }
    public LinkedList<Integer> getShortPath(Integer toPoint) {
        LinkedList<Integer> list = new LinkedList<>();
        Integer fromPoint = toPoint;
        do  {
            fromPoint = mapFromPoint[fromPoint];
            list.addFirst(fromPoint);
        } while (fromPoint != START_POINT);

        return list;
    }
}
