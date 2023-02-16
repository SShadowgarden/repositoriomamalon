package co.edu.uptc.model;

public class NodeClass {
    private Object value;
    private NodeClass next;

    public NodeClass() {
        value = null;
        next = null;
    }

    public NodeClass(Object value) {
        this.value = value;
        next = null;
    }
    public NodeClass(Object value, NodeClass next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public NodeClass getNext() {
        return next;
    }

    public void setNext(NodeClass next) {
        this.next = next;
    }
}
