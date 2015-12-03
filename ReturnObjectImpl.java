/**
 * Implementation of ReturnObject Interface
 *
 * @author Laurent Mignot
 */

public abstract class ReturnObjectImpl implements ReturnObject {

    private ErrorMessage error = null;
    private Object obj;

    public ReturnObjectImpl (Object obj) {
        this.obj = obj;
    }

    public boolean hasError() {
        return (this.error != null && this.error != ErrorMessage.NO_ERROR);
    };

    public ErrorMessage getError() {
        return this.error;
    };

    public Object getReturnValue() {
        return this.obj;
    };

}