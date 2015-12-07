/**
 * Implementation of ReturnObject Interface
 *
 * @author Laurent Mignot
 */
public class ReturnObjectImpl implements ReturnObject {

    private ErrorMessage error;
    private Object obj;

    /**
     * Constructs a ReturnObject wrapping the given object
     * Sets the default error message to ErrorMessage.NO_ERROR
     * @param obj The object to store
     */
    public ReturnObjectImpl (Object obj) {
        this.error = ErrorMessage.NO_ERROR;
        this.obj = obj;
    }

    /**
     * Constructs a ReturnObject with an error message
     * If null is passed, the error state defaults to ErrorMessage.NO_ERROR
     * @param error The error message
     */
    public ReturnObjectImpl (ErrorMessage error) {
        this.error = (error != null) ? error : ErrorMessage.NO_ERROR;
        this.obj = null;
    }

    /**
     * @see ReturnObject#hasError()
     */
    @Override
    public boolean hasError () {
        return (this.error != null && this.error != ErrorMessage.NO_ERROR);
    };

    /**
     * @see ReturnObject#getError()
     */
    @Override
    public ErrorMessage getError () {
        return this.error;
    };

    /**
     * @see ReturnObject#getReturnValue()
     */
    @Override
    public Object getReturnValue () {
        return !this.hasError() ? this.obj : null;
    };

}