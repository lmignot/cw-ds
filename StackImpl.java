/**
 * A Stack Implementation
 *
 * @author Laurent Mignot
 */
public class StackImpl extends AbstractStack {

    /**
     * @see Stack#isEmpty()
     */
    public boolean isEmpty () {
        return true;
    }

    /**
     * @see Stack#size()
     */
    public int size () {
        return 0;
    }

    /**
     * @see Stack#push()
     */
    public void push (Object item) {

    }

    /**
     * @see Stack#top()
     */
    public ReturnObject top () {
        return new ReturnObjectImpl(null);
    }

    /**
     * @see Stack#pop()
     */
    public ReturnObject pop() {
        return new ReturnObjectImpl(null);
    }
}