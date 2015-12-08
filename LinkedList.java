/**
 * Implementation of a List as a LinkedList
 *
 * @author Laurent Mignot
 */
public class LinkedList implements List {

    private int size;
    private Node head;
    private Node tail;

    public LinkedList () {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * @see List#isEmpty()
     */
    @Override
    public boolean isEmpty () {
        return this.size == 0;
    }

    /**
     * @see List#size()
     */
    @Override
    public int size () {
        return this.size;
    }

    /**
     * @see List#get()
     */
    @Override
    public ReturnObject get (int index)  {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        if (this.isOutOfBounds(index)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        if (index == 0) {
            return new ReturnObjectImpl(this.head.getValue());
        } else if (index == (this.size - 1)) {
            return new ReturnObjectImpl(this.tail.getValue());
        } else {
            return new ReturnObjectImpl(this.getNodeAtIndex(index).getValue());
        }
    }

    /**
     * @see List#remove()
     */
    @Override
    public ReturnObject remove (int index) {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        if (this.isOutOfBounds(index)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        Node toRemove;

        if (index == 0) {
            toRemove = this.head;
            this.head = toRemove.getNext();
        } else if (index == (this.size - 1)) {
            toRemove = this.tail;
            this.tail = toRemove.getPrev();
        } else {
            toRemove = this.getNodeAtIndex(index);
        }

        Node before = toRemove.getPrev();
        Node after = toRemove.getNext();

        if (before != null) { before.setNext(after); }
        if (after != null) { after.setPrev(before); }

        this.size--;
        return new ReturnObjectImpl(toRemove.getValue());
    }

    /**
     * @see List#add(int, Object)
     */
    @Override
    public ReturnObject add (int index, Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        if (this.isOutOfBounds(index)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        Node newNode = new Node(item);

        if (index == 0) {
            Node first = this.head;
            this.head = newNode;
            this.head.setNext(first);
            first.setPrev(this.head);
        } else if (index == (this.size - 1)) {
            Node last = this.tail;
            this.tail = newNode;
            this.tail.setPrev(last);
            last.setNext(this.tail);
        } else {
            Node addAfter = this.getNodeAtIndex(index - 1);
            newNode.setNext(addAfter.getNext());
            addAfter.getNext().setPrev(newNode);
            addAfter.setNext(newNode);
            newNode.setPrev(addAfter);
        }

        this.size++;
        return new ReturnObjectImpl(null);
    }

    /**
     * @see List#add(Object)
     */
    @Override
    public ReturnObject add (Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        if (this.head == null) {
            this.head = new Node(item);
            this.tail = this.head;
        } else {
            Node last = this.tail;
            this.tail = new Node(item);
            this.tail.setPrev(last);
            last.setNext(this.tail);
        }

        this.size++;
        return new ReturnObjectImpl(null);
    }

    public Node getHead () {
        return this.head;
    }

    /**
     * Retrieves a Node in the list at the given index
     * @param index
     * @return the Node at the given index
     */
    private Node getNodeAtIndex (int index) {
        int currentIndex = 0;
        Node current;

        if (index > Math.abs((this.size - 1) / 2)) {
            current = this.tail;
            currentIndex = this.size - 1;
            while (current.getPrev() != null) {
                if (currentIndex == index) { break; }
                current = current.getPrev();
                currentIndex--;
            }
        } else {
            current = this.head;
            while (current.getNext() != null) {
                if (currentIndex == index) { break; }
                current = current.getNext();
                currentIndex++;
            }
        }
        return current;
    }

    /**
     * Check whether the given index is out of bounds of the data structure
     * @param index the index to check
     * @return true if out of bounds, false otherwise
     */
    private boolean isOutOfBounds (int index) {
        return (index < 0 || index > (this.size - 1));
    }
}