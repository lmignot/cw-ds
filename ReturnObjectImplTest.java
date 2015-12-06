import org.junit.*;
import static org.junit.Assert.*;

public class ReturnObjectImplTest {

    @Test
    public void brandNewObjectShouldReturnFalseWhenHasErrorIsCalled() {
        ReturnObject obj = new ReturnObjectImpl(null);
        assertEquals("ReturnObject with no error should return false when hasError is called", false, obj.hasError());
    }

    @Test
    public void emptyObjectShouldReturnNullWhenGetReturnValueIsCalled() {
        ReturnObject obj = new ReturnObjectImpl(null);
        assertEquals("empty ReturnObject should return null when getReturnValue is called", null, obj.getReturnValue());
    }

    @Test
    public void shouldReturnNoErrorIfHasErrorEqualsFalse() {
        ReturnObject obj = new ReturnObjectImpl(null);
        ErrorMessage test = ErrorMessage.NO_ERROR;

        assertEquals("hasError should equal false", false, obj.hasError());
        assertEquals("should return NO_ERROR if hasError equals false", test, obj.getError());
    }

    @Test
    public void shouldReturnErrorAndNullIfHasObjectAndAlsoError() {
        ErrorMessage test = ErrorMessage.INVALID_ARGUMENT;
        ReturnObject obj = new ReturnObjectImpl(test);

        assertEquals("hasError should return true if ReturnObject has error", true, obj.hasError());
        assertEquals("getReturnValue should return null if ReturnObject has error", null, obj.getReturnValue());
    }

    @Test
    public void shouldReturnObjectIfHasObjectAndHasNoError() {
        String str = "Test";
        ReturnObject obj = new ReturnObjectImpl(str);

        assertEquals("hasError should be false", false, obj.hasError());
        assertEquals("should return wrapped object if there is no error", str, obj.getReturnValue());
    }

}