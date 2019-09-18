package Graphs.Models;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;


public class Writter {

    private static Formatter output;
    private String algorithm;
    private boolean directed;
    public Writter(String algorithmType, Graph graph, boolean directed) {
        this.algorithm = algorithmType;
        this.directed = directed;
        generateFile(graph);
    }

    private void generateFile(Graph graph) {
        String header;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.hh.mm");
        Date currentDate = new Date();


        String fileName = "output" + "/" + algorithm + "/" + algorithm + "-" + graph.getNum() + "-" + dateFormat.format(currentDate) + ".gv";

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

}
