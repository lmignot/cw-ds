import org.junit.*;
import static org.junit.Assert.*;

public class ImprovedStackTest {

    @Test
    public void improvedStackTest() {
        ImprovedStack stack = new ImprovedStackImpl();

        assertEquals("stack should be empty", stack.isEmpty(), true);
        assertEquals("stack should have size 0", stack.size(), 0);

        ReturnObject top = stack.top();

        assertEquals("top should have an error", top.hasError(), true);
        assertEquals("top should return empty structure error", top.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("top should return null as value", top.getReturnValue(), null);

        ReturnObject pop = stack.pop();

        assertEquals("pop should have an error", pop.hasError(), true);
        assertEquals("pop should return empty structure error", pop.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("pop should return null as value", pop.getReturnValue(), null);

    }

    @Test
    public void improvedStackStressTest() {
        ImprovedStack stack = new ImprovedStackImpl();

        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            stack.push(i);
        }

        assertEquals("stack should have 1 million items", stack.size(), oneMillion);
        assertEquals("stack should not be empty", stack.isEmpty(), false);

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

        assertEquals("stack should be empty", stack.isEmpty(), true);
        assertEquals("stack should have size 0", stack.size(), 0);
    }

    @Test
    public void testImprovedStackRemove() {
        ImprovedStack stack = new ImprovedStackImpl();
        int fiftyK = 50000;
        int fiveHundredK = 25000;

        for (int i = 0; i < fiftyK; i++) {
            if (i % 2 == 0) {
                stack.push("Test string " + 2);
            } else {
                stack.push("Test string " + 1);
            }
        }

        assertEquals("stack should have 50k items",
                stack.size(), fiftyK);

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