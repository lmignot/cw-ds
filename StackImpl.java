/**
 * A Stack Implementation
 *
 * @author Laurent Mignot
 */
public class StackImpl extends AbstractStack {

    public StackImpl (List list) {
        super(list);
    }

    /**
     * @see Stack#isEmpty()
     */
    public boolean isEmpty () {
        return this.internalList.isEmpty();
    }

    /**
     * @see Stack#size()
     */
    public int size () {
        return this.internalList.size();
    }

    /**
     * @see Stack#push()
     */
    public void push (Object item) {
        if (item != null) {
            this.internalList.add(item);
        }
    }

    /**
     * @see Stack#top()
     */
    public ReturnObject top () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.internalList.get(this.size() - 1);
    }

    /**
     * @see Stack#pop()
     */
    public ReturnObject pop() {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.internalList.remove(this.size() - 1);
    }
}