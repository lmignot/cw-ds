import org.junit.*;
import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void emptyList() {
        List list = new ArrayList();

        assertEquals("it should have size 0", list.size(), 0);
        assertEquals("it should be empty", list.isEmpty(), true);

        assertEquals("it should return EMPTY_STRUCTURE when get is called",
                list.get(2).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("it should return INDEX_OUT_OF_BOUNDS when remove is called",
                list.remove(4).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }

    @Test
    public void addToList() {
        List list = new ArrayList();
        int zero = 1;
        String one = "Some value";
        double two = 10.242;
        double three = 3.14;
        String four = "The quick brown fox jumps over the lazy dog";
        String five = "Somewhere over the rainbow";
        int six = 69;
        int seven = 53;
        double eight = 112.45;
        String nine = "Lorem ipsum dolor sit amet";
        int ten = 99;
        String eleven = "Some random text";
        double twelve = 89.98;

        ReturnObject test = list.add(zero);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(2, four);
        list.add(five);
        list.add(six);
        list.add(5, seven);
        list.add(eight);
        list.add(nine);

        assertFalse("it should not be empty", list.isEmpty());
        assertEquals("it should have size 10", list.size(), 10);
        assertFalse("returned object should have no error", test.hasError());
        assertNull("returned object should be empty", test.getReturnValue());

        list.add(7, ten);
        ReturnObject tenReturn = list.get(7);
        assertEquals("it should now have size 11", list.size(), 11);
        assertFalse("returned object should have no error", tenReturn.hasError());
        assertEquals("returned object should have correct value", tenReturn.getReturnValue(), ten);

        ReturnObject outOfBoundsTest = list.add(-2, eleven);
        assertTrue("returned object should have error",
                outOfBoundsTest.hasError());
        assertEquals("returned object should have out of bounds error",
                outOfBoundsTest.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals("it should still have size 11", list.size(), 11);

        ReturnObject outOfBoundsTest2 = list.add(list.size() + 1, eleven);
        assertTrue("returned object should have error",
                outOfBoundsTest2.hasError());
        assertEquals("returned object should have out of bounds error",
                outOfBoundsTest2.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals("it should still have size 11", list.size(), 11);

        list.add(eleven);
        ReturnObject elevenReturn = list.get(11);
        assertEquals("it should now have size 12", list.size(), 12);
        assertFalse("returned object should have no error", elevenReturn.hasError());
        assertEquals("returned object should have correct value", elevenReturn.getReturnValue(), eleven);

        list.add(0, twelve);
        ReturnObject twelveReturn = list.get(0);
        assertEquals("it should now have size 13", list.size(), 13);
        assertFalse("returned object should have no error", twelveReturn.hasError());
        assertEquals("returned object should have correct value", twelveReturn.getReturnValue(), twelve);

        ReturnObject nullCheck = list.add(null);
        assertEquals("it should still have size 13", list.size(), 13);
        assertTrue("returned object should have error", nullCheck.hasError());
        assertEquals("returned object should have invalid argument error",
                nullCheck.getError(), ErrorMessage.INVALID_ARGUMENT);

        nullCheck = list.add(5, null);
        assertEquals("it should still have size 13", list.size(), 13);
        assertTrue("returned object should have error", nullCheck.hasError());
        assertEquals("returned object should have invalid argument error",
                nullCheck.getError(), ErrorMessage.INVALID_ARGUMENT);

        int size = list.size() - 1;

        for (int i = size; i >= 0; i--) {
            list.remove(i);
        }

        assertEquals("it should have size 0", list.size(), 0);
        assertEquals("it should be empty", list.isEmpty(), true);

        assertEquals("it should return EMPTY_STRUCTURE when get is called",
                list.get(2).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("it should return INDEX_OUT_OF_BOUNDS when remove is called",
                list.remove(4).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }

    @Test
    public void removeFromList() {
        List list = new ArrayList();

        int zero = 1;
        String one = "Some value";
        double two = 10.242;
        double three = 3.14;
        String four = "The quick brown fox jumps over the lazy dog";
        String five = "Somewhere over the rainbow";
        int six = 69;
        int seven = 53;
        double eight = 112.45;
        String nine = "Lorem ipsum dolor sit amet";
        int ten = 99;
        String eleven = "Some random text";
        double twelve = 89.98;

        list.add(zero);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(2, four);
        list.add(five);
        list.add(six);
        list.add(5, seven);
        list.add(eight);
        list.add(nine);
        list.add(7, ten);
        list.add(eleven);
        list.add(0, twelve);

        assertFalse("it should not be empty", list.isEmpty());
        assertEquals("it should have size 13", list.size(), 13);

        ReturnObject outOfBoundsTest = list.remove(-2);
        assertTrue("returned object should have error",
                outOfBoundsTest.hasError());
        assertEquals("returned object should have out of bounds error",
                outOfBoundsTest.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals("it should still have size 13", list.size(), 13);

        ReturnObject outOfBoundsTest2 = list.remove(list.size());
        assertTrue("returned object should have error",
                outOfBoundsTest2.hasError());
        assertEquals("returned object should have out of bounds error",
                outOfBoundsTest2.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals("it should still have size 13", list.size(), 13);

        ReturnObject zeroR = list.remove(1);
        assertEquals("it should now have size 12", list.size(), 12);
        assertEquals("removed object should have correct value", zeroR.getReturnValue(), zero);

        ReturnObject twelveR = list.remove(0);
        assertEquals("it should now have size 11", list.size(), 11);
        assertEquals("removed object should have correct value", twelveR.getReturnValue(), twelve);

        ReturnObject elevenR = list.remove(10);
        assertEquals("it should now have size 10", list.size(), 10);
        assertEquals("removed object should have correct value", elevenR.getReturnValue(), eleven);

        ReturnObject fiveR = list.remove(5);
        assertEquals("it should now have size 9", list.size(), 9);
        assertEquals("removed object should have correct value", fiveR.getReturnValue(), five);

        int len = list.size() - 1;
        for (int i = len; i >= 0; i--) {
            list.remove(i);
        }
        assertEquals("it should have size 0", list.size(), 0);
        assertTrue("it should be empty", list.isEmpty());
        assertEquals("it should return EMPTY_STRUCTURE when get is called",
                list.get(2).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("it should return INDEX_OUT_OF_BOUNDS when remove is called",
                list.remove(4).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        ReturnObject outOfBoundsTest3 = list.add(2, zero);
        assertEquals("returned object should have error",
                outOfBoundsTest3.hasError(), true);
        assertEquals("returned object should have error INDEX_OUT_OF_BOUNDS",
                outOfBoundsTest3.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals("it should still have size 0", list.size(), 0);
        assertTrue("it should still be empty", list.isEmpty());
    }

    @Test
    public void stressTest() {
        List list = new ArrayList();
        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            if (i % 2 == 0) {
                list.add("xyz-" + i);
            } else {
                list.add(i);
            }
        }

        assertEquals("list should have 1 million items", list.size(), oneMillion);

        for (int i = oneMillion - 1; i >= 0; i--) {
            list.remove(i);
        }

        assertEquals("list should be empty", list.isEmpty(), true);
        assertEquals("list should have size 0", list.size(), 0);
    }
}