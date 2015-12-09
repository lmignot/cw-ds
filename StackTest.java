import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void stackTest() {
        Stack stack = new StackImpl(new ArrayList());

        assertEquals("stack should be empty", stack.isEmpty(), true);
        assertEquals("stack should have size 0", stack.size(), 0);


    }
}