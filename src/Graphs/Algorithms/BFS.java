package Graphs.Algorithms;

import java.util.List;
import java.util.ArrayList;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;

import Graphs.Models.Handlers.Queue;


public class BFS extends Algorithm{

    public BFS(Graph graph) {
        edgesBFS = new ArrayList<>();

        for (int i = 0; i < graph.getVertexes().size(); i++) {
            if (!graph.getVertexes().get(i).getVertexes().isEmpty()) {
                graph.getVertexes().get(i).setExplored(false);
            }
        }

    }

    private List<Edge> edgesBFS;
    public List<Edge> getEdgesBFS() {
        return edgesBFS;
    }
    public void setEdgesBFS(List<Edge> edgesBFS) {
        this.edgesBFS = edgesBFS;
    }

    public List<Edge> BFSAlgorithm(Graph graph, Vertex vertex) {
        Queue queue = new Queue();
        vertex.setExplored(true);
        queue.enqueue(vertex);
        while (!queue.isEmpty()) {
            Vertex addedVertex = (Vertex) queue.front();
            queue.dequeue();
            for (int i = 0; i < addedVertex.getVertexes().size(); i++) {
                Edge edge = addedVertex.getVertexes().get(i);
                int idAdjacentVertex = Integer.parseInt(edge.getVertexB());
                System.out.println(idAdjacentVertex);
                    if (graph.getVertexes().get(idAdjacentVertex).getExplored()) {
                        graph.getVertexes().get(idAdjacentVertex).setExplored(true);
                        queue.add(graph.getVertexes().get(idAdjacentVertex));
                        edgesBFS.add(edge);
                    }
            }
        }
        return edgesBFS;
    }
}
