import org.junit.*;
import static org.junit.Assert.*;

public class ReturnObjectImplTest {

    @Test
    public void brandNewObjectShouldReturnFalseWhenHasErrorIsCalled() {
        ReturnObject obj = new ReturnObjectImpl(null, null);
        assertEquals(false, obj.hasError());
    }

    @Test
    public void emptyObjectShouldReturnNullWhenGetReturnValueIsCalled() {
        ReturnObject obj = new ReturnObjectImpl(null, null);
        assertEquals(null, obj.getReturnValue());
    }

    @Test
    public void shouldReturnNoErrorIfHasErrorEqualsFalse() {
        ReturnObject obj = new ReturnObjectImpl(null, null);
        ErrorMessage test = ErrorMessage.NO_ERROR;

        assertEquals(false, obj.hasError());
        assertEquals(test, obj.getError());
    }

    @Test
    public void shouldReturnErrorAndNullIfHasObjectAndAlsoError() {
        ErrorMessage test = ErrorMessage.INVALID_ARGUMENT;
        ReturnObject obj = new ReturnObjectImpl("Test", test);

        assertEquals(true, obj.hasError());
        assertEquals(null, obj.getReturnValue());
    }

    @Test
    public void shouldReturnObjectIfHasObjectAndHasNoError() {
        String str = "Test";
        ReturnObject obj = new ReturnObjectImpl(str, null);

        assertEquals(false, obj.hasError());
        assertEquals(str, obj.getReturnValue());
    }

}