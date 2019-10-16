package Graphs.Models;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Writter {

    private static Formatter output;
    private String algorithm;
    private boolean directed;

    public Writter(String algorithmType, boolean directed, List<Edge> edges, int num) {
        this.algorithm = algorithmType;
        this.directed = directed;
        generateFileTree((ArrayList<Edge>) edges, num);
    }
    public Writter(String algorithmType, Graph graph, boolean directed) {
        this.algorithm = algorithmType;
        this.directed = directed;
        generateFileGraph(graph, graph.getNum());
    }

    private void generateFileTree(ArrayList<Edge> edges, int num) {
        String header;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.hh.mm.ss");
        Date currentDate = new Date();

        String fileName = "output" + "/" + algorithm + "/" + algorithm + "-" + num + "-" + dateFormat.format(currentDate) + ".gv";

        if(directed) {
            header = "digraph " + algorithm + "{\n";
        } else {
            header = "graph " + algorithm + "{\n";
        }

        String endGraph = "}";
        String fileBody = header + generateTree(edges) + endGraph;

        try {
            output = new java.util.Formatter(fileName);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error, cannot open file");
            System.exit(1);
        }
        try {
            output.format("%s", fileBody);
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error, cannot open file");
        }
        if (output != null) {
            output.close();
        }
    }


    private void generateFileGraph(Graph graph, int num) {
        String header;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.hh.mm.ss");
        Date currentDate = new Date();

        String fileName = "output" + "/" + algorithm + "/" + algorithm + "-" + num + "-" + dateFormat.format(currentDate) + ".gv";

        if(directed) {
            header = "digraph " + algorithm + "{\n";
        } else {
            header = "graph " + algorithm + "{\n";
        }

        String endGraph = "}";
        String fileBody = header + generateGraph(graph) + endGraph;

        try {
            output = new java.util.Formatter(fileName);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error, cannot open file");
            System.exit(1);
        }
        try {
            output.format("%s", fileBody);
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error, cannot open file");
        }
        if (output != null) {
            output.close();
        }
    }

    private String generateGraph(Graph graph) {
        StringBuilder graphBuilder = new StringBuilder();

        if (!graph.getVertexes().isEmpty()) {
//            for (int i = 0; i < graph.getVertexes().size(); i++) {
//                graphBuilder.append("n").append(i).append(";\n");
//            }
            for (int i = 0; i < graph.getVertexes().size(); i++) {
                if (!graph.getVertexes().get(i).getVertexes().isEmpty()) {
                    for (int j = 0; j < graph.getVertexes().get(i).getVertexes().size(); j++) {
                        if(directed) {
                            graphBuilder.append("n").append(graph.getVertexes().get(i).getVertex(j).getVertexA())
                                    .append("->").append("n").append(graph.getVertexes().get(i).getVertex(j).getVertexB())
                                    .append(";").append("\n");
                        }

                        else {
                            graphBuilder.append("n").append(graph.getVertexes().get(i).getVertex(j).getVertexA())
                                    .append("--").append("n").append(graph.getVertexes().get(i).getVertex(j).getVertexB())
                                    .append(";").append("\n");
                        }
                    }
                }
            }
        } else {
            graphBuilder = new StringBuilder("Empty vertexes");
        }
        return graphBuilder.toString();
    }


    private String generateTree(ArrayList<Edge> edges) {
        StringBuilder graphBuilder = new StringBuilder();

        if (!edges.isEmpty()) {
            for (Edge edgesBF : edges) {
                graphBuilder.append("n").append(edgesBF.getVertexA())
                        .append("->").append("n").append(edgesBF.getVertexB())
                        .append(";").append("\n");
            }
        } else {
            graphBuilder = new StringBuilder("Empty edges");
        }
        return graphBuilder.toString();
    }

}
