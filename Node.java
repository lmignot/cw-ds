/**
 * Represents a Node in a LinkedList
 *
 * @author Laurent Mignot
 */
public class Node {

    private int position;
    private Object value;
    private Node next;
    private Node prev;

    public Node (int position, Object value) {
        this.position = position;
        this.value = value;
    }

    public Object getValue () {
        return this.value;
    }

    public Object getPosition () {
        return this.position;
    }

    public Node getNext () {
        return this.next;
    }
}