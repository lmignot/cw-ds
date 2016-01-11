import org.junit.*;
import static org.junit.Assert.*;

public class SampleableListTest {

    @Test
    public void stressTestSampleableList() {
        SampleableList list = new SampleableListImpl();
        int oneMillion = 1000000;
        int fiveHundredK = 500000;

        for (int i = 0; i < oneMillion; i++) {
            if (i % 2 == 0) {
                list.add("xyz-" + i);
            } else {
                list.add(i);
            }
        }

        SampleableList sample = list.sample();

        assertEquals("sample should have 500000 items", sample.size(), fiveHundredK);

        ReturnObject oneA = list.get(0);
        ReturnObject oneB = sample.get(0);

        assertEquals("oneA should be the same as oneB",
                oneA.getReturnValue(), oneB.getReturnValue());

        ReturnObject threeA = list.get(2);
        ReturnObject twoB = sample.get(1);

        assertEquals("threeA should be the same as twoB",
                threeA.getReturnValue(), twoB.getReturnValue());

        ReturnObject fiveA = list.get(4);
        ReturnObject threeB = sample.get(2);

        assertEquals("fiveA should be the same as threeB",
                fiveA.getReturnValue(), threeB.getReturnValue());
    }

    @Test
    public void emptySampleableList() {
        SampleableList list = new SampleableListImpl();
        SampleableList sample = list.sample();

        assertEquals("sample should have 0 items", sample.size(), 0);
        assertTrue("sample should be empty", sample.isEmpty());

    }
}