/**
 * Implementation of FunctionalList extending ArrayList
 *
 * @author Laurent Mignot
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
    /**
     * @see FunctionalList#head()
     */
    @Override
    public ReturnObject head () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        return new ReturnObjectImpl(this.storage[0]);
    }

    /**
     * @see FunctionalList#rest()
     */
    @Override
    public FunctionalList rest () {
        FunctionalList list = new FunctionalArrayList();

        if (this.isEmpty() || this.size == 1) {
            return list;
        }
        // not efficient, @TODO: improve this
        for (int i = 1; i < this.size; i++) {
            list.add(this.get(i));
        }

        return list;
    }
}