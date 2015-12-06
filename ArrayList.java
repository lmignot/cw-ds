/**
 * Implementation of List as an ArrayList
 *
 * @author Laurent Mignot
 */
public class ArrayList implements List {

    // Keep our storage capacity to a reasonable starting size
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
        if (this.outOfBounds(index)) {
            return new ReturnObject(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }
        return storage[index];
    }

    public ReturnObject remove (int index) {
        if (this.isEmpty()) {
            return new ReturnObject(null, ErrorMessage.EMPTY_STRUCTURE);
        }
        if (this.outOfBounds(index)) {
            return new ReturnObject(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

    }

    public ReturnObject add (int index, Object item) {
        // return out of bounds if
        // [1] this is an empty list and index is not 0
        // [2] not empty but index is less than 0
        // [3] index is greater than size - assume we should not have blank spaces in our list
        if ((this.isEmpty() && index != 0) || index < 0 || index > this.size) {
            return new ReturnObject(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        // if index == size then we simply add the item to the end
        if (index == this.size) {
            return this.add(item);
        }

        if (this.shouldIncreaseStorage()) {
            this.increaseStorage();
        }
        ReturnObject obj = new ReturnObject(item, null);
        // get the current item at this position
        ReturnObject current = this.storage[index];
        // set the new item to that position
        this.storage[index] = obj;

        // shift all remaining entries over
        for (int i = index + 1; i <= this.size; i++) {
            ReturnObject tmp = this.storage[i];
            this.storage[i] = current;
            current = tmp;
        }
        this.size++;
        return obj;
    }

    public ReturnObject add (Object item) {
        if (this.shouldIncreaseStorage()) {
            this.increaseStorage();
        }
        ReturnObject obj = new ReturnObject(item, null);
        this.storage[this.size] = obj;
        this.size++;
        return obj;
    }

    private boolean outOfBounds (int index) {
        return (index < 0 || index > (this.size - 1)) ? true : false;
    }

    private boolean shouldIncreaseStorage () {
        return this.size >= this.storage.length;
    }

    private boolean canDecreaseStorage () {
        return (this.storage.length / 2) >= this.size;
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