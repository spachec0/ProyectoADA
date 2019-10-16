package Graphs.Models;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int num;
    private List<Vertex> vertexes;
    private List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges, int num){
        this.vertexes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.num = num;
        setVertexes(vertexes);
        setEdges(edges);
    }

    public static Graph newInstance (Graph graph) {
        return new Graph(graph.getVertexes(),graph.getEdges(),graph.getNum());
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }
    
    public Vertex getVertex(int index) {
        if(index > 0 && index <= vertexes.size()){
            return vertexes.get(index);
        }else{
            return null;
        }
    }
    
    private void setVertexes(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
    
    public Edge getEdge(int index) {
        if(index > 0 && index <= vertexes.size()){
            return edges.get(index);
        }else{
            return null;
        }
    }

    public int getNum(){
        return this.num;
    }
    private void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

}
