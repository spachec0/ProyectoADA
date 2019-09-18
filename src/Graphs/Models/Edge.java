package Graphs.Models;

public class Edge {

    private String vertexA;
    private String vertexB;

    public void setVertexes(String vertexA, String vertexB) { this.vertexA = vertexA; this.vertexB = vertexB;}

    public String getVertexA() {
        return vertexA;
    }
    public void setVertexA(String vertexA) { this.vertexA = vertexA; }

    public String getVertexB() {
        return vertexB;
    }
    public void setVertexB(String vertexB) {
        this.vertexB = vertexB;
    }
}
