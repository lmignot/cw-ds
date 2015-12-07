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

        FunctionalList list = new FunctionalLinkedList();

        if (this.isEmpty()) {
            return list;
        }

        for (int i = 1; i < this.size; i++) {
            list.add(this.get(i));
        }

        return list;
    }
}