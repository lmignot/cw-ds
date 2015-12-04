/**
 * Implementation of ReturnObject Interface
 *
 * @author Laurent Mignot
 */

public class ReturnObjectImpl implements ReturnObject {

    private ErrorMessage error;
    private Object obj;

    public ReturnObjectImpl () {
        this.error = ErrorMessage.NO_ERROR;
        this.obj = null;
    }

    public void setObject (Object obj) {
        this.obj = obj;
    }

    public void setError (ErrorMessage error) {
        this.error = error;
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