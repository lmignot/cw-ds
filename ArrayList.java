/**
 * Implementation of a List as an ArrayList
 *
 * @author Laurent Mignot
 */
public class ArrayList implements List {

    private final static int MIN_STORAGE_CAPACITY = 20;
    private int size;
    private Object[] storage;

    public ArrayList () {
        this.size = 0;
        this.storage = new Object[MIN_STORAGE_CAPACITY];
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
        return new ReturnObjectImpl(this.storage[index]);
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

    /**
     * @see List#add(int, Object)
     */
    @Override
    public ReturnObject add (int index, Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        if (this.isEmpty() || this.isOutOfBounds(index)) {
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
     * Checks whether the given index is out of bounds of the data structure
     * @param index the index to check
     * @return true if out of bounds, false otherwise
     */
    private boolean isOutOfBounds (int index) {
        return (index < 0 || index > (this.size - 1));
    }

    /**
     * Checks if we need to increase data structure capacity
     * @return true if we should increase capacity, false otherwise
     */
    private boolean shouldIncreaseStorage () {
        return this.size >= this.storage.length;
    }

    /**
     * Checks if we can reduce data structure capacity
     * @return true if we can decrease capacity, false otherwise
     */
    private boolean canDecreaseStorage () {
        return (this.storage.length / 2) >= this.size;
    }

    /**
     * Increases the capacity of data structure, maintaining any data in storage
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
     * Reduces the capacity of data structure, maintaining any data in storage
     * Reduced capacity will never be less than {@MIN_STORAGE_SIZE}
     */
    private void decreaseStorage () {
        int oldCapacity = this.storage.length;
        int newCapacity = oldCapacity / 2;
        if (newCapacity < this.MIN_STORAGE_CAPACITY) {
            newCapacity = this.MIN_STORAGE_CAPACITY;
        }

        Object[] tmp = new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            tmp[i] = this.storage[i];
        }
        this.storage = tmp;
    }
}