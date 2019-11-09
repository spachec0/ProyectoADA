package Graphs.Models;

import java.util.List;

public class Edge {

    private String vertexA;
    private String vertexB;
    private float wheight;

    public Edge(){
    }

    public Edge(float bound){
        this.wheight = (float) (Math.random() * bound);
    }

    public void setVertexes(String vertexA, String vertexB) { this.vertexA = vertexA; this.vertexB = vertexB;}

    public String getVertexA() {
        return vertexA;
    }
    public void setVertexA(String vertexA) { this.vertexA = vertexA; }

    public String getVertexB() { return vertexB; }
    public void setVertexB(String vertexB) {
        this.vertexB = vertexB;
    }

    public float getWeight() { return wheight; }

    @Override
    public String toString(){
        return "Vertex A: "+ vertexA + " Vertex B:" + vertexB;
    }

}
