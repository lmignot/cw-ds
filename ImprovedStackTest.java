import org.junit.*;
import static org.junit.Assert.*;

public class ImprovedStackTest {

    @Test
    public void testImprovedStackRemove() {
        ImprovedStack stack = new ImprovedStackImpl();
        int oneMillion = 50000;
        int fiveHundredK = 25000;

        for (int i = 0; i < oneMillion; i++) {
            if (i % 2 == 0) {
                stack.push("Test string " + 2);
            } else {
                stack.push("Test string " + 1);
            }
        }

        assertEquals("stack should have 50k items",
                stack.size(), oneMillion);

        assertEquals("stack should not be empty",
                stack.isEmpty(), false);

        stack.remove("Test string " + 2);

        assertEquals("stack should now have 25k items",
                stack.size(), fiveHundredK);
    }

    @Test
    public void testImprovedStackReverse() {
        ImprovedStack stack = new ImprovedStackImpl();
        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            stack.push(i + 1);
        }

        assertEquals("stack should have one million items",
                stack.size(), oneMillion);

        assertEquals("stack should not be empty",
                stack.isEmpty(), false);

        ImprovedStack reverse = stack.reverse();

        assertEquals("reverse should have one million items",
                reverse.size(), oneMillion);

        assertEquals("reverse top should equal one",
                reverse.top().getReturnValue(), 1);
    }
}