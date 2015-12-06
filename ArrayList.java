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
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        if (this.isOutOfBounds(index)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }
        return new ReturnObjectImpl(this.storage[index]);
    }

    public ReturnObject remove (int index) {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        if (this.isOutOfBounds(index)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        ReturnObject obj = new ReturnObjectImpl(this.storage[index]);

        for (int i = index; i < this.size; i++) {
            Object tmp = this.storage[i + 1];
            this.storage[i] = tmp;
        }

        if (this.canDecreaseStorage()) {
            this.decreaseStorage();
        }

        this.size--;
        return obj;
    }

    public ReturnObject add (int index, Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        // return out of bounds if
        // [1] this is an empty list and index is not 0
        // [2] not empty but index is less than 0
        // [3] index is greater than size (assume we should not have blank spaces in our list)
        if ((this.isEmpty() && index != 0) || index < 0 || index > this.size) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        // if index equals size then we simply add the item to the end
        if (index == this.size) {
            return this.add(item);
        }

        if (this.shouldIncreaseStorage()) {
            this.increaseStorage();
        }
        // get the current item at the index
        Object current = this.storage[index];
        // set the new item to that index
        this.storage[index] = item;

        // shift all remaining entries over
        for (int i = index + 1; i <= this.size; i++) {
            Object tmp = this.storage[i];
            this.storage[i] = current;
            current = tmp;
        }
        this.size++;
        return new ReturnObjectImpl(null);
    }

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

    private boolean isOutOfBounds (int index) {
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