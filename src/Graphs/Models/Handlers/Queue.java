package Graphs.Models.Handlers;

import java.util.ArrayList;

public class Queue extends ArrayList<Object> {

    public void enqueue(Object object) {
        if (object != null) {
            this.add(object);
        }
    }

    public void dequeue() {
        if (this.size() > 0) {
            this.remove(0);
        }
    }

    public Object front() {
        Object auxObject = null;
        if (this.size() > 0) {
            auxObject = this.get(0);
        }
        return auxObject;
    }

    public boolean empty() {
        return this.isEmpty();
    }
}
