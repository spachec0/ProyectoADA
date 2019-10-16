package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Handlers.Stack;

import java.util.ArrayList;
import java.util.List;

public class DFS extends Algorithm{

    private List<Edge> edgesDFS;
    public List<Edge> getEdgesDFS() {
        return edgesDFS;
    }
    public void setEdgesDFS(List<Edge> edgesBFS) {
        this.edgesDFS = edgesBFS;
    }

    public DFS(Graph graph) {
        edgesDFS = new ArrayList<>();

        for (int i = 0; i < graph.getVertexes().size(); i++) {
            if (!graph.getVertexes().get(i).getVertexes().isEmpty()) {
                graph.getVertexes().get(i).setExplored(false);
            }
        }
    }

    public List<Edge> recursiveDFS(Graph graph, Vertex vertex) {
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            if (!graph.getVertexes().get(i).getVertexes().isEmpty()) {
                if (vertex.getExplored()) {
                    vertex.setExplored(true);
                    for (int j = 0; j < vertex.getVertexes().size(); j++) {
                        int idVertex = Integer.parseInt(vertex.getVertex(j).getVertexB());
                        try {
                            if (graph.getVertexes().get(idVertex).getExplored()) {
                                edgesDFS.add(vertex.getVertex(j));
                                System.out.println(vertex.getVertex(j));
                                recursiveDFS(graph, graph.getVertexes().get(idVertex));
                            }
                        } catch (Exception e) {
                            System.out.println("Broke out in: " + idVertex);
                            e.printStackTrace(System.out);
                        }
                    }
                }
            }
        }
        return edgesDFS;
    }

    public List<Edge> iterativeDFS(Graph graph, Vertex vertex) {

        for (int i = 0; i < graph.getVertexes().size(); i++) {
            if (!graph.getVertexes().get(i).getVertexes().isEmpty()) {
                Stack stack = new Stack();
                vertex.setExplored(true);
                stack.push(vertex);
                while (!stack.isEmpty()) {
                    Vertex addedVertex = (Vertex) stack.top();
                    stack.pop();
                    for (int j = 0; j < addedVertex.getVertexes().size(); j++) {
                        Edge edge = addedVertex.getVertexes().get(j);
                        int idAdjacentVertex = Integer.parseInt(edge.getVertexB());
                        if (graph.getVertexes().get(idAdjacentVertex).getExplored()) {
                            graph.getVertexes().get(idAdjacentVertex).setExplored(true);
                            stack.add(graph.getVertexes().get(idAdjacentVertex));
                            edgesDFS.add(edge);
                        }
                    }
                }
            }
        }
        return edgesDFS;
    }
}
