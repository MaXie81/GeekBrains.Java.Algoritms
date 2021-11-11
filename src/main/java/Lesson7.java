import graph.BreadthFirstSearch;
import graph.DepthFirstSearch;
import graph.Graph;

import java.util.Arrays;

public class Lesson7 {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.setLink(6, 5);
        graph.setLink(3, 5);
        graph.setLink(5, 7);
        graph.setLink(5, 1);
        graph.setLink(7, 4);
        graph.setLink(4, 0);
        graph.setLink(4, 2);
        graph.setLink(2, 1);
        graph.setLink(1, 0);
        graph.setLink(0, 2);

        System.out.println("Смежные узлы с узлом " + 4 + ": " + graph.getLinkList(4));

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        System.out.println("Обход в глубину. Таблица связанности: " + Arrays.asList(depthFirstSearch.getMapFromPoint()));
        System.out.println("Обход в глубину. Есть ли путь до узла "+ 6 + ": " + depthFirstSearch.isPath(6));

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, 0);
        System.out.println("Обход в ширину. Таблица связанности: " + Arrays.asList(breadthFirstSearch.getMapFromPoint()));
        System.out.println("Обход в глубину. Кротчайший путь до узла "+ 7 + ": " + breadthFirstSearch.getShortPath(7));
    }
}
