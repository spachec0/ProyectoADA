package Graphs.Algorithms;

import Graphs.Models.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Algorithm {

    Random randomGenerator;
    List<Vertex> vertexes;

    Algorithm() {
        randomGenerator = new Random();
        vertexes = new ArrayList<>();
    }

    int generateNumber(int maxNumber) {
        int initialNumber = 0;
        return initialNumber + randomGenerator.nextInt(maxNumber);
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }
}
