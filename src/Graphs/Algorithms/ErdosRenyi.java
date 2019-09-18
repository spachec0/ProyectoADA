package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Writter;

public class ErdosRenyi extends Algorithm {

    public ErdosRenyi(int n, int m, boolean directed) {
        super();
        String algorithmType = "ErdosRenyi";
        for (int i = 0; i < n; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }

        System.out.println("[+] Erdos-Renyi");
        ErdosRenyiAlgorithm(m);
        Graph graph = new Graph(vertexes, null, n);
        Writter file = new Writter(algorithmType, graph, directed);
    }

    private void ErdosRenyiAlgorithm(int m) {

        for (int j = 0; j < m; j++) {
            Edge edge = new Edge();
            int edge1 = generateNumber(vertexes.size());
            int edge2 = generateNumber(vertexes.size());

            if (vertexes.get(edge1).getVertexes().isEmpty()) {
                while (edge2 == edge1) {
                    edge2 = generateNumber(vertexes.size());
                }
                edge.setVertexes(String.valueOf(edge1), String.valueOf(edge2));
                vertexes.get(edge1).addEdge(edge);

            } else if (!vertexes.get(edge1).getVertexes().isEmpty()) {
                boolean nodeExist = false;
                while (!nodeExist) {
                    for (int i = 0; i < vertexes.get(edge1).getVertexes().size(); i++) {
                        if (vertexes.get(edge1).getVertex(i).getVertexB().equals(String.valueOf(edge2))) {
                            nodeExist = true;
                            break;
                        }
                    }
                    if (nodeExist) {
                        edge2 = generateNumber(vertexes.size());
                    } else {
                        edge.setVertexes(String.valueOf(edge1), String.valueOf(edge2));
                        vertexes.get(edge1).addEdge(edge);
                    }
                }
            }
        }
    }
}
