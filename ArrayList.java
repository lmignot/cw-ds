/**
 * Implementation of List as an ArrayList
 *
 * @author Laurent Mignot
 */
public class ArrayList implements List {

    // Keep our list from being reduced to below a reasonable starting size
    public static final int minStorageSize = 4;

    private int size;
    private Object[] storage;

    public ArrayList () {
        this.size = 0;
        this.storage = new Object[minStorageSize];
    }

    public boolean isEmpty () {
        return this.size == 0;
    }

    public int size () {
        return this.size;
    }

    public ReturnObject get (int index)  {
        if (this.isEmpty()) {
            return new ReturnObject(null, ErrorMessage.EMPTY_STRUCTURE);
        }
        if (index < 0 || index > (this.size - 1)) {
            return new ReturnObject(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

    }

    public ReturnObject remove (int index) {
        if (this.isEmpty()) {
            return new ReturnObject(null, ErrorMessage.EMPTY_STRUCTURE);
        }

    }

    public ReturnObject add (int index, Object item) {
        // if this is an empty list specified index can only be 0
        if (this.isEmpty() && index != 0) {
            return new ReturnObject(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

    }

    public ReturnObject add (Object item) {

    }

    /**
     * Increases the capacity of storage Array, maintaining any data in storage
     */
    private void increaseStorage () {
        int oldCapacity = this.storage.length;
        int newCapacity = oldCapacity * 2;
        Object[] tmp = new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            tmp[i] = this.storage[i];
        }
        this.storage = tmp;
    }

    /**
     * Reduces the capacity of storage Array, maintaining any data in storage
     * Reduced capacity will never be less than {@minStorageSize}
     */
    private void decreaseStorage () {
        int oldCapacity = this.storage.length;
        int newCapacity = oldCapacity / 2;
        if (newCapacity < this.minStorageSize) {
            newCapacity = this.minStorageSize;
        }

        Object[] tmp = new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            tmp[i] = this.storage[i];
        }
        this.storage = tmp;
    }
}