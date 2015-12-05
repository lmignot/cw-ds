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

    }

    public ReturnObject remove (int index) {

    }

    public ReturnObject add (int index, Object item) {

    }

    public ReturnObject add(Object item) {

    }

    private void increaseStorage () {

    }

    private void decreaseStorage () {

    }
}