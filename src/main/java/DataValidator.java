import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 07/11/2014.
 */
public class   DataValidator {
    private int expectedDatasetSize;

    public DataValidator(int _expectedDatasetSize){
        this.expectedDatasetSize = _expectedDatasetSize;
    }

    public boolean validCriticalFields(String[] array) {
        return true;
    }



    public void setExpectedDatasetSize(int expectedDatasetSize) {
        this.expectedDatasetSize = expectedDatasetSize;
    }

    public int getExpectedDatasetSize() {
        return expectedDatasetSize;
    }

    public boolean validDatasetSize(String[] inputArray) {

        if (expectedDatasetSize ==inputArray.length)  return true;
        return false;

            }

    public List validateDataFields(String[] inputArray) {
        //always valid - returns no errors
        return new ArrayList<String>();

    }
}
