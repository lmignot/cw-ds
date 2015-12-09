/**
 * Implementation of interface SampleableList
 *
 * @author Laurent Mignot
 */
public class SampleableListImpl extends ArrayList implements SampleableList {

    /**
     * @see  SampleableList#sample()
     */
    public SampleableList sample () {
        SampleableList list = new  SampleableListImpl();

        for (int i = 0; i < this.size(); i++) {
            if (i % 2 == 0) {
                list.add(this.get(i).getReturnValue());
            }
        }

        return list;
    }
}
