package Graphs.Models;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Writter {

    private static Formatter output;
    private String algorithm;
    private boolean directed;

    public Writter(String algorithmType, Graph graph, boolean directed, boolean named) {
        this.algorithm = algorithmType;
        this.directed = directed;

        if(named) {
            if(algorithmType.equals("Geographic") || algorithmType.equals("Gilbert")
                    || algorithmType.equals("ErdosRenyi") || algorithmType.equals("BarabasiAlbert")){
                generateFileGraph(graph, graph.getNum(), true);
            } else {
                generateFileNamedDijkstra(graph, graph.getNum());
            }
        }

        else {
            generateFileGraph(graph, graph.getNum(), false);
        }
    }


    private void generateFileNamedDijkstra(Graph graph, int num) {
        String header;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.hh.mm.ss");
        Date currentDate = new Date();

        String fileName = "output" + "/" + algorithm + "/" + algorithm + "-" + num + "-" + dateFormat.format(currentDate) + ".gv";

        if (directed) {
            header = "digraph " + algorithm + "{\n";
        } else {
            header = "graph " + algorithm + "{\n";
        }

        String endGraph = "}";

        String fileBody;
        fileBody = header + namedGraph(graph) + endGraph;

        try {
            output = new Formatter(fileName);
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

    private void generateFileGraph(Graph graph, int num, boolean named) {
        String header;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.hh.mm.ss");
        Date currentDate = new Date();

        String fileName = "output" + "/" + algorithm + "/" + algorithm + "-" + num + "-" + dateFormat.format(currentDate) + ".gv";

        if (directed) {
            header = "digraph " + algorithm + "{\n";
        } else {
            header = "graph " + algorithm + "{\n";
        }

        String endGraph = "}";

        String fileBody;
        fileBody = header + generateGraph(graph, named) + endGraph;

        try {
            output = new Formatter(fileName);
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

    private String generateGraph(Graph graph, boolean named) {
        StringBuilder graphBuilder = new StringBuilder();

        if (!graph.getVertexes().isEmpty()) {
//            for (int i = 0; i < graph.getVertexes().size(); i++) {
//                graphBuilder.append("n").append(i).append(";\n");
//            }
            for (int i = 0; i < graph.getVertexes().size(); i++) {
                if (!graph.getVertexes().get(i).getVertexes().isEmpty()) {
                    for (int j = 0; j < graph.getVertexes().get(i).getVertexes().size(); j++) {
                        if(named) {
                            if (directed) {
                                graphBuilder.append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexA())
                                        .append(" -> ")
                                        .append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexB())
                                        .append(" [label=")
                                        .append(graph.getVertexes().get(i).getVertex(j).getWeight())
                                        .append("]")
                                        .append(";")
                                        .append("\n");
                            } else {
                                graphBuilder.append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexA())
                                        .append(" -- ")
                                        .append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexB())
                                        .append(" [label=")
                                        .append(graph.getVertexes().get(i).getVertex(j).getWeight())
                                        .append("]")
                                        .append(";")
                                        .append("\n");
                            }
                        } else {
                            if (directed) {
                                graphBuilder.append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexA())
                                        .append(" -> ")
                                        .append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexB())
                                        .append(";")
                                        .append("\n");
                            } else {
                                graphBuilder.append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexA())
                                        .append(" -- ")
                                        .append("n")
                                        .append(graph.getVertexes().get(i).getVertex(j).getVertexB())
                                        .append(";")
                                        .append("\n");
                            }
                        }
                    }
                }
            }
        } else {
            graphBuilder = new StringBuilder("Empty vertexes");
        }
        return graphBuilder.toString();
    }


    private String namedGraph(Graph graph) {
        StringBuilder graphBuilder = new StringBuilder();
        if (!graph.getVertexes().isEmpty()) {
            for (int i = 0; i < graph.getVertexes().size(); i++) {
                if (graph.getVertexes().get(i) != null) {
                    String test = graphBuilder.toString();
                    if (!test.contains("n" + graph.getVertexes().get(i).getId())) {
                        graphBuilder.append("n")
                                .append(graph.getVertexes().get(i).getId())
                                .append(" [label=\"n")
                                .append(graph.getVertexes().get(i).getId())
                                .append(" (")
                                .append(graph.getVertexes().get(i).getDistance())
                                .append(")\"]")
                                .append("\n");
                    }
                }
            }

            for (int i = 0; i < graph.getVertexes().size(); i++) {
                if (graph.getVertexes().get(i) != null) {
                    if (!graph.getVertexes().get(i).getPreviousVertex().equals("-")) {

                        boolean inBounds = i < graph.getVertexes().get(i).getVertexes().size();
                        if(!inBounds) {
                            break;
                        }

                        if(directed) {
                            graphBuilder.append("n")
                                    .append(graph.getVertexes().get(i).getId())
                                    .append(" -> ")
                                    .append("n")
                                    .append(graph.getVertexes().get(i).getPreviousVertex())
                                    .append(" [label=")
                                    .append(graph.getVertexes().get(i).getDistance())
                                    .append("]")
                                    .append(";")
                                    .append("\n");
                        } else {
                            graphBuilder.append("n")
                                    .append(graph.getVertexes().get(i).getId())
                                    .append(" -- ")
                                    .append("n")
                                    .append(graph.getVertexes().get(i).getPreviousVertex())
                                    .append(" [label=")
                                    .append(graph.getVertexes().get(i).getDistance())
                                    .append("]")
                                    .append(";")
                                    .append("\n");
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

