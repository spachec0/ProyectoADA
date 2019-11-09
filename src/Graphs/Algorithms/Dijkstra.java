package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Handlers.Queue;
import Graphs.Models.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Dijkstra {
    public List<Vertex> runDijkstra(Graph g) {

        List<Vertex> vertexes = g.getVertexes();
        List<Vertex> shortPath = new ArrayList<>();

        Random r = new Random();
        int sN = r.nextInt(vertexes.size());
//        int tN = r.nextInt(vertexes.size() + 1);
//
//        if (sN == tN) {
//            tN = (int) (Math.random() * (vertexes.size())) + 1;
//        }

        Vertex s = vertexes.get(sN);
        s.setDistance(0);
        s.setPreviousVertex("-");

        Queue queue = new Queue();
        queue.add(s);

        for (int j = 0; j < g.getVertexes().size(); j++) {

            if (g.getVertexes().get(j) == null) {
                continue;
            }
            while (!queue.isEmpty()) {
                Vertex n = getSmVertex(queue);
                queue.remove(n);
                n.setExplored(true);
                List<Edge> v = n.getVertexes();
                for (Edge edge : v) {
                    String id = edge.getVertexB();
                    float weightA = edge.getWeight();
                    float distanceS = n.getDistance();

                    Vertex next = lookVertex(id, g);

                    if (next.getDistance() < 0) {
                        next.setDistance(distanceS + weightA);
                        next.setPreviousVertex(n.getId());
                        queue.add(next);
                        //System.out.println("ENTRO MENOR");
                    } else if (next.getDistance() > distanceS + weightA) {
                        next.setDistance(distanceS + weightA);
                        next.setPreviousVertex(n.getId());
                        queue.add(next);
                        //System.out.println("ENTRO MAYOR");
                    }
                }
            }
        }
        for (int j = 0; j < g.getVertexes().size(); j++) {

            if (g.getVertexes().get(j) == null) {
                continue;
            }

            Vertex target = vertexes.get(j);
            if (!target.getPreviousVertex().equals("")) {
                shortPath.add(target);
                getDijkstraPath(target, g, shortPath);
            }
        }
//            else {
//                getDijkstraPathOrg(s, g, shortPath);
//            }

        return shortPath;
    }

    private void getDijkstraPath(Vertex n, Graph g, List<Vertex> dijkstraVertexes) {
        if (!n.getPreviousVertex().equals("-")) {
            Vertex nP = lookVertex(n.getPreviousVertex(), g);
            dijkstraVertexes.add(nP);
            getDijkstraPath(nP, g, dijkstraVertexes);
        }
    }

    private void getDijkstraPathOrg(Vertex n, Graph g, List<Vertex> dijkstraVertexes) {
        if (n != null) {
            Vertex nP = lookPreviousVertex(n.getId(), g);
            dijkstraVertexes.add(nP);
            getDijkstraPathOrg(nP, g, dijkstraVertexes);
        } else {
            System.out.println("Final vertex: ");
        }
    }

    private Vertex getSmVertex(Queue c) {
        Vertex n = null;
        c.sort(Comparator.comparing(Vertex::getDistance));
        for (Object object : c) {
            n = (Vertex) object;
            if (!n.getExplored()) {
                break;
            }
        }
        return n;
    }

    private Vertex lookVertex(String id, Graph g) {
        Vertex foundVertex = null;
        for (Vertex vertex : g.getVertexes()) {
            if (vertex.getId().equals(id)) {
                foundVertex = vertex;
            }
        }
        return foundVertex;
    }

    private Vertex lookPreviousVertex(String id, Graph g) {
        Vertex foundVertex = null;
        for (Vertex vertex : g.getVertexes()) {
            if (vertex.getPreviousVertex().equals(id)) {
                foundVertex = vertex;
            }
        }
        return foundVertex;
    }
}
