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
        return new ReturnObjectImpl(this.get(0).getReturnValue());
    }

    /**
     * @see FunctionalList#rest()
     */
    @Override
    public FunctionalList rest () {

        FunctionalList list = new FunctionalLinkedList();

        if (this.isEmpty() || this.size() == 1) {
            return list;
        }

        int length = this.size();

        // this takes waaaay too long
        // @TODO: improve this
        for (int i = 1; i < length; i++) {
            list.add(this.get(i).getReturnValue());
        }

        return list;
    }
}