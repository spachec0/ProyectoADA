package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Writter;

import java.util.ArrayList;
import java.util.List;

public class BarabasiAlbert extends Algorithm {

    private static String algorithmType = "BarabasiAlbert";
    private double connectionProbability = randomGenerator.nextDouble();

    public BarabasiAlbert(int n, int d, boolean directed, int index, String type) {
        super();
        vertexes = new ArrayList<>();

        BarabasiAlbertAlgorithm(n, d);
        Graph graph =  new Graph(vertexes,null, n);
        Writter file0 = new Writter(algorithmType, graph, directed);
    }

    public BarabasiAlbert(int n, int d, boolean directed) {
        super();
        vertexes = new ArrayList<>();
        System.out.println("[+] Barabasi Albert");
        BarabasiAlbertAlgorithm(n, d);
        Graph graph =  new Graph(vertexes,null, n);

        Writter file = new Writter(algorithmType, graph, directed);

    }

    private void BarabasiAlbertAlgorithm(int n, int d) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                Vertex vertex = new Vertex(i, algorithmType);
                vertexes.add(vertex);
            } else {
                Vertex vertex = new Vertex(i, algorithmType);
                if (connectProbableVertex(vertexes, vertex, d)) {
                    vertexes.add(vertex);
                }
            }
        }
    }

    private boolean connectProbableVertex(List<Vertex> valVertexes, Vertex newVertex, int d) {
        double probability = 0;
        double newProbability;
        boolean addVertex = false;

        for (Vertex valVertex : valVertexes) {
            newProbability = connectionProbability(valVertex, d);
            if (newProbability > probability) {
                probability = newProbability;
            }
        }

        for (Vertex valVertex : valVertexes) {
            double rand = randomGenerator.nextDouble();
            boolean connectionProb = connectionProbability > rand;
            if((connectionProb) && (valVertex.getGrade() < d) && (newVertex.getGrade() < d)) {
                Edge edge = new Edge();
                edge.setVertexes(valVertex.getId(), newVertex.getId());
                decreaseGrade(valVertex, newVertex, d);
                valVertex.addEdge(edge);
                addVertex = true;
            }
        }
        return addVertex;
    }

    private void decreaseGrade(Vertex vertexA, Vertex vertexB, int d) {
        decreaseVertexGradeX(vertexA, d);
        decreaseVertexGradeX(vertexB, d);
    }

    private void decreaseVertexGradeX(Vertex vertex, int d) {
        if (vertex.getGrade() < d) {
            int connections = vertex.getGrade() + 1;
            vertex.setGrade(connections);
            double newProbability = 1 - ((float) vertex.getGrade() / d);
            vertex.setProbability(newProbability);
        } else {
            System.out.println("Out of connections");
        }
    }

    private double connectionProbability(Vertex vertex, int d) {
        double connections = 0;
        if (vertex.getGrade() > 0) {
            connections = 1 - ((float) vertex.getGrade() / d);
        } else if (vertex.getGrade() == 0) {
            connections = 1;
        }
        return connections;
    }
}