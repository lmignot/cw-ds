/**
 * Implementation of ReturnObject Interface
 *
 * @author Laurent Mignot
 */
public class ReturnObjectImpl implements ReturnObject {

    private ErrorMessage error;
    private Object obj;

    /**
     * After much deliberation decided to implement this as a single constructor
     * Based on ErrorMessage the errors indicate that this object would have no value
     * if there is an error. So it seems like when creating a ReturnObject we would
     * either have an error or an object.
     * @param obj The object to store
     * @param error An error message if any, else defaults to null
     */
    public ReturnObjectImpl (Object obj, ErrorMessage error) {
        this.error = (error == null) ? ErrorMessage.NO_ERROR : error;
        this.obj = obj;
    }

    public boolean hasError () {
        return (this.error != null && this.error != ErrorMessage.NO_ERROR);
    };

    public ErrorMessage getError () {
        return this.error;
    };

    public Object getReturnValue () {
        return !this.hasError() ? this.obj : null;
    };

}