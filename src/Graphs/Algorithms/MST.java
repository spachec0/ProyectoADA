package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Handlers.Queue;
import Graphs.Models.Vertex;

import java.util.*;

public class MST {

    public List<Vertex> InverseKruskal(Graph g) {

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

        Graphs.Models.Handlers.Queue queue = new Graphs.Models.Handlers.Queue();
        queue.add(s);

        for (int j = 0; j < g.getVertexes().size(); j++) {

            if (g.getVertexes().get(j) == null) {
                continue;
            }
            while (!queue.isEmpty()) {
                Vertex n = union(queue);
                queue.remove(n);
                n.setExplored(true);
                List<Edge> v = n.getVertexes();
                for (Edge edge : v) {
                    String id = edge.getVertexB();
                    float weightA = edge.getWeight();
                    float distanceS = n.getDistance();

                    Vertex next = find(id, g);

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
                MSTgraph(target, g, shortPath);
            }
        }
//            else {
//                getDijkstraPathOrg(s, g, shortPath);
//            }

        return shortPath;
    }

    public List<Vertex> Kruskal(Graph g) {

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

        Graphs.Models.Handlers.Queue queue = new Graphs.Models.Handlers.Queue();
        queue.add(s);

        for (int j = 0; j < g.getVertexes().size(); j++) {

            if (g.getVertexes().get(j) == null) {
                continue;
            }
            while (!queue.isEmpty()) {
                Vertex n = union(queue);
                queue.remove(n);
                n.setExplored(true);
                List<Edge> v = n.getVertexes();
                for (Edge edge : v) {
                    String id = edge.getVertexB();
                    float weightA = edge.getWeight();
                    float distanceS = n.getDistance();

                    Vertex next = find(id, g);

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
                MSTgraph(target, g, shortPath);
            }
        }
//            else {
//                getDijkstraPathOrg(s, g, shortPath);
//            }

        return shortPath;
    }

    public List<Vertex> Prim(Graph g) {

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

        Graphs.Models.Handlers.Queue queue = new Graphs.Models.Handlers.Queue();
        queue.add(s);

        for (int j = 0; j < g.getVertexes().size(); j++) {

            if (g.getVertexes().get(j) == null) {
                continue;
            }
            while (!queue.isEmpty()) {
                Vertex n = union(queue);
                queue.remove(n);
                n.setExplored(true);
                List<Edge> v = n.getVertexes();
                for (Edge edge : v) {
                    String id = edge.getVertexB();
                    float weightA = edge.getWeight();
                    float distanceS = n.getDistance();

                    Vertex next = find(id, g);

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
                MSTgraph(target, g, shortPath);
            }
        }
//            else {
//                getDijkstraPathOrg(s, g, shortPath);
//            }

        return shortPath;
    }

    private void MSTgraph(Vertex n, Graph g, List<Vertex> dijkstraVertexes) {
        if (!n.getPreviousVertex().equals("-")) {
            Vertex nP = find(n.getPreviousVertex(), g);
            dijkstraVertexes.add(nP);
            MSTgraph(nP, g, dijkstraVertexes);
        }
    }

    private Vertex union(Queue c) {
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

    private Vertex find(String id, Graph g) {
        Vertex foundVertex = null;
        for (Vertex vertex : g.getVertexes()) {
            if (vertex.getId().equals(id)) {
                foundVertex = vertex;
            }
        }
        return foundVertex;
    }

    private Vertex checkExplored(String id, Graph g) {
        Vertex foundVertex = null;
        for (Vertex vertex : g.getVertexes()) {
            if (vertex.getPreviousVertex().equals(id)) {
                foundVertex = vertex;
            }
        }
        return foundVertex;
    }

}
