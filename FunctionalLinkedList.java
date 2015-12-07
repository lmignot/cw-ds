/**
 * Implementation of FunctionalList extending LinkedList
 *
 * @author Laurent Mignot
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    /**
     * @see FunctionalList#head()
     */
    @Override
    public ReturnObject head () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        return new ReturnObjectImpl(this.head.getValue());
    }

    /**
     * @see FunctionalList#rest()
     */
    @Override
    public FunctionalList rest () {
        // @TODO: implement this
        return this; // temporary
    }
}