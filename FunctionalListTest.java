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

        for (int i = (oneMillion - 1); i >= 0; i--) {
            list.remove(i);
        }

        assertEquals("it should have size 0", list.size(), 0);
        assertEquals("it should be empty", list.isEmpty(), true);

        assertEquals("it should return EMPTY_STRUCTURE when get is called",
                list.get(2).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("it should return INDEX_OUT_OF_BOUNDS when remove is called",
                list.remove(4).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        for (int i = (oneMillion - 2); i >= 0; i--) {
            rest.remove(i);
        }

        assertEquals("it should have size 0", rest.size(), 0);
        assertEquals("it should be empty", rest.isEmpty(), true);

        assertEquals("it should return EMPTY_STRUCTURE when get is called",
                rest.get(2).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("it should return INDEX_OUT_OF_BOUNDS when remove is called",
                rest.remove(4).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
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

        for (int i = (oneMillion - 1); i >= 0; i--) {
            linkedList.remove(i);
        }

        assertEquals("it should have size 0", linkedList.size(), 0);
        assertEquals("it should be empty", linkedList.isEmpty(), true);

        assertEquals("it should return EMPTY_STRUCTURE when get is called",
                linkedList.get(2).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("it should return INDEX_OUT_OF_BOUNDS when remove is called",
                linkedList.remove(4).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        for (int i = (oneMillion - 2); i >= 0; i--) {
            rest.remove(i);
        }

        assertEquals("it should have size 0", rest.size(), 0);
        assertEquals("it should be empty", rest.isEmpty(), true);

        assertEquals("it should return EMPTY_STRUCTURE when get is called",
                rest.get(2).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("it should return INDEX_OUT_OF_BOUNDS when remove is called",
                rest.remove(4).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }
}