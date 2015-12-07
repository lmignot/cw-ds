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
        // @TODO: implement this
        return new ReturnObjectImpl(null);
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

        // @TODO: implement
        ReturnObject obj = new ReturnObjectImpl(null);

        this.size--;
        return obj;
    }

    /**
     * @see List#add(int, Object)
     */
    @Override
    public ReturnObject add (int index, Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        if (this.isEmpty() || index < 0 || index >= this.size) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        if (this.shouldIncreaseStorage()) {
            this.increaseStorage();
        }

        Object current = this.storage[index];
        this.storage[index] = item;

        for (int i = index + 1; i <= this.size; i++) {
            Object tmp = this.storage[i];
            this.storage[i] = current;
            current = tmp;
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
        if (this.shouldIncreaseStorage()) {
            this.increaseStorage();
        }

        this.storage[this.size] = item;
        this.size++;
        return new ReturnObjectImpl(null);
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