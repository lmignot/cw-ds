/**
 * Represents a Node in a LinkedList
 *
 * @author Laurent Mignot
 */
public class Node {

    private Object value;
    private Node next;
    private Node prev;

    public Node (Object value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Object getValue () {
        return this.value;
    }

    public Node getNext () {
        return this.next;
    }

    public void setNext (Node n) {
        this.next = n;
    }

    public Node getPrev () {
        return this.prev;
    }

    public void setPrev (Node p) {
        this.prev = p;
    }
}