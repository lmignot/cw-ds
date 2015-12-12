/**
 * Implementation of an ImprovedStack
 * As we cannot extend AbstractStack or Stack we could use
 * an internal stack - however the code ends up very similar
 * so have opted to simply use a list internally and implement Stack interface
 * methods.
 *
 * @author Laurent Mignot
 */
public class ImprovedStackImpl implements ImprovedStack {

    protected List dataStructure;

    public ImprovedStackImpl (List list) {
        if (list != null) {
            this.dataStructure = list;
        }
    }

    /**
     * @see Stack#isEmpty()
     */
    public boolean isEmpty () {
        if (this.dataStructure != null) {
            return this.dataStructure.isEmpty();
        } else {
            return true;
        }
    }

    /**
     * @see Stack#size()
     */
    public int size () {
        if (this.dataStructure != null) {
            return this.dataStructure.size();
        } else {
            return 0;
        }
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
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.dataStructure.get(this.size() - 1);
    }

    /**
     * @see Stack#pop()
     */
    public ReturnObject pop () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.dataStructure.remove(this.size() - 1);
    }

    /**
     * @see ImprovedStack#reverse()
     */
    public ImprovedStack reverse () {
        List newList = new ArrayList();

        if (!this.isEmpty()) {
            for (int i = this.dataStructure.size() - 1; i >= 0; i--) {
                newList.add(this.dataStructure.get(i).getReturnValue());
            }
        }

        return new ImprovedStackImpl(newList);
    };

    /**
     * @see ImprovedStack#remove()
     */
    public void remove (Object object) {
        if (!this.isEmpty()) {
            for (int i = 0; i < this.dataStructure.size(); i++) {
                if (this.dataStructure.get(i).getReturnValue().equals(object)){
                    this.dataStructure.remove(i);
                }
            }
        }
    }
}