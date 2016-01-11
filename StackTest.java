import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void stackTest() {
        Stack stack = new StackImpl(new ArrayList());

        assertTrue("stack should be empty", stack.isEmpty());
        assertEquals("stack should have size 0", stack.size(), 0);

        String test = "Sample item";

        stack.push(test);

        ReturnObject top = stack.top();
        assertFalse("top should not have an error", top.hasError());
        assertEquals("top should return no error", top.getError(), ErrorMessage.NO_ERROR);
        assertEquals("top should return correct value", top.getReturnValue(), test);

        ReturnObject pop = stack.pop();
        assertFalse("pop should not have an error", pop.hasError());
        assertEquals("pop should return no error", pop.getError(), ErrorMessage.NO_ERROR);
        assertEquals("pop should return correct value", pop.getReturnValue(), test);

        assertEquals("stack should be empty", stack.isEmpty(), true);
        assertEquals("stack should have size 0", stack.size(), 0);

        top = stack.top();

        assertTrue("top should have an error", top.hasError());
        assertEquals("top should return empty structure error", top.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("top should return null as value", top.getReturnValue());

        pop = stack.pop();

        assertTrue("pop should have an error", pop.hasError());
        assertEquals("pop should return empty structure error", pop.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("pop should return null as value", pop.getReturnValue());
    }

    @Test
    public void stackNullTest() {
        Stack stack = new StackImpl(null);

        assertTrue("stack should be empty", stack.isEmpty());
        assertEquals("stack should have size 0", stack.size(), 0);

        stack.push("Sample item");

        assertTrue("stack should still be empty", stack.isEmpty());
        assertEquals("stack should still have size 0", stack.size(), 0);

        ReturnObject top = stack.top();

        assertTrue("top should have an error", top.hasError());
        assertEquals("top should return empty structure error", top.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("top should return null as value", top.getReturnValue());

        ReturnObject pop = stack.pop();

        assertTrue("pop should have an error", pop.hasError());
        assertEquals("pop should return empty structure error", pop.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("pop should return null as value", pop.getReturnValue());
    }

    @Test
    public void stackStressTest() {
        Stack stack = new StackImpl(new ArrayList());

        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            stack.push(i);
        }

        assertEquals("stack should have 1 million items", stack.size(), oneMillion);
        assertFalse("stack should not be empty", stack.isEmpty());

        ReturnObject top = stack.top();

        assertEquals("top should be 999999", top.getReturnValue(), oneMillion - 1);

        stack.pop();

        top = stack.top();
        assertEquals("top should be 999998", top.getReturnValue(), oneMillion - 2);

        ReturnObject pop;

        for (int i = oneMillion - 2; i >= 0; i--) {
            pop = stack.pop();
            assertEquals("pop should equal correct value", pop.getReturnValue(), i);
        }

        assertTrue("stack should be empty", stack.isEmpty());
        assertEquals("stack should have size 0", stack.size(), 0);
    }
}