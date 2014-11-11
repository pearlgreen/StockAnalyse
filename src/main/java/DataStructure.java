import com.sun.org.apache.bcel.internal.generic.ObjectType;

/**
 * Created by James on 11/11/2014.
 */
public class DataStructure {
    private int index;

    public int getIndex() {
        return index;
    }

    public String getColumn_name() {
        return column_name;
    }

    public boolean isShouldNotBeNull() {
        return shouldNotBeNull;
    }

    private String column_name;
    private boolean shouldNotBeNull;

    public DataStructure(int i, String s1, boolean b) {

        index = i;
        column_name = s1;
        shouldNotBeNull = b;


    }
}
