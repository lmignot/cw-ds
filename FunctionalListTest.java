import org.junit.*;
import static org.junit.Assert.*;

public class FunctionalListTest {

    @Test
    public void stressTestFunctionalArrayList() {
        FunctionalList list = new FunctionalArrayList();
        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            if (i % 2 == 0) {
                list.add("xyz-" + i);
            } else {
                list.add(i);
            }
        }

        assertEquals("list should have 1 million items", list.size(), oneMillion);

        ReturnObject head = list.head();
        assertEquals("head should be the first item", head.getReturnValue(), "xyz-0");

        FunctionalList rest = list.rest();
        assertEquals("list should have 999999 items", rest.size(), 999999);

        assertEquals("list should still have 1 million items", list.size(), oneMillion);
    }

    @Test
    public void stressTestFunctionalLinkedList() {
        FunctionalList linkedList = new FunctionalLinkedList();
        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            if (i % 2 == 0) {
                linkedList.add("xyz-" + i);
            } else {
                linkedList.add(i);
            }
        }

        assertEquals("list should have 1 million items", linkedList.size(), oneMillion);

        ReturnObject head = linkedList.head();
        assertEquals("head should be the first item", head.getReturnValue(), "xyz-0");

        FunctionalList rest = linkedList.rest();
        assertEquals("list should have 999999 items", 999999, rest.size());

        assertEquals("list should still have 1 million items", linkedList.size(), oneMillion);
    }
}