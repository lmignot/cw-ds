/**
 * Implementation of an ImprovedStack
 *
 * @author Laurent Mignot
 */
public class ImprovedStackImpl implements ImprovedStack {

    protected List dataStructure;

    public ImprovedStackImpl (List list) {
        this.dataStructure = list;
    }

    /**
     * @see Stack#isEmpty()
     */
    public boolean isEmpty () {
        return this.dataStructure != null ? this.dataStructure.isEmpty() : true;
    }

    /**
     * @see Stack#size()
     */
    public int size () {
        return this.dataStructure != null ? this.dataStructure.size() : 0;
    }

    /**
     * @see Stack#push()
     */
    public void push (Object item) {
        if (this.dataStructure != null && item != null) {
            this.dataStructure.add(item);
        }
    }

    /**
     * @see Stack#top()
     */
    public ReturnObject top () {
        if (this.dataStructure == null || this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.dataStructure.get(this.size() - 1);
    }

    /**
     * @see Stack#pop()
     */
    public ReturnObject pop () {
        if (this.dataStructure == null || this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.dataStructure.remove(this.size() - 1);
    }

    /**
     * @see ImprovedStack#reverse()
     */
    public ImprovedStack reverse () {
        ImprovedStack newStack = new ImprovedStackImpl(new ArrayList());

        if (!this.isEmpty()) {
            int size = this.dataStructure.size() - 1;
            for (int i = size; i >= 0; i--) {
                newStack.push(this.dataStructure.get(i).getReturnValue());
            }
        }

        return newStack;
    };

    /**
     * @see ImprovedStack#remove()
     */
    public void remove (Object object) {
        if (!this.isEmpty()) {
            int size = this.dataStructure.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (this.dataStructure.get(i).getReturnValue().equals(object)){
                    this.dataStructure.remove(i);
                }
            }
        }
    }
}
