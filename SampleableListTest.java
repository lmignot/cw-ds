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

        assertEquals("list should have 500000 items", sample.size(), fiveHundredK);

        ReturnObject oneA = list.get(0);
        ReturnObject oneB = sample.get(0);

        assertEquals("oneA should be the same as oneB",
                oneA.getReturnValue(), oneB.getReturnValue());

        ReturnObject threeA = list.get(2);
        ReturnObject twoB = sample.get(1);

        assertEquals("threeA should be the same as twoB",
                threeA.getReturnValue(), twoB.getReturnValue());
    }
}