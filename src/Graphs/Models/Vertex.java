package Graphs.Models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String id;
    private List<Edge> vertexes;
    private int grade = 0;

    private int distance;

    private double coordX;
    private double coordY;
    private boolean exist = false;
    private String previousVertex;
    private double probability = 1;
    private boolean explored = false;


    public Vertex(int id, String tipo) {
        setId(String.valueOf(id));
        vertexes = new ArrayList<>();

        if (tipo.equals("Geographic")) {
            SecureRandom random = new SecureRandom();
            coordX = random.nextDouble();
            coordY = random.nextDouble();
        }
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public Edge getVertex(int id) {
        return vertexes.get(id);
    }

    public void setVertex(Edge edge, int id) {
        this.vertexes.set(id, edge);
    }

    public List<Edge> getVertexes() { return vertexes; }

    public void setVertexes(List<Edge> vertexes) {
        this.vertexes = vertexes;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public void addEdge(Edge edge) {
        this.vertexes.add(edge);
    }

    public boolean getExplored() { return !explored; }
    public void setExplored(boolean explored) { this.explored = explored; }


}
