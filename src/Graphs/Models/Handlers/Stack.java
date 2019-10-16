package Graphs.Models.Handlers;

import Graphs.Models.Vertex;

import java.util.ArrayList;
import java.util.Comparator;

public class Stack extends ArrayList<Object> {

    public void push(Object object) {
        if (object != null) {
            this.add(object);
        } else {
            System.out.println("Introduzca un dato no nulo");
        }
    }

    public void pop() {
        if (size() > 0) {
            this.remove(this.size() - 1);
        }
    }

    public Object top() {
        Object auxObject = null;
        if (this.size() > 0) {
            auxObject = this.get(this.size() - 1);
        }
        return auxObject;
    }

    public boolean empty() {
        return this.isEmpty();
    }

}
