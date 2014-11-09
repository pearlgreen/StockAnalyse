/**
 * Created by James on 07/11/2014.
 */
public class   DataValidator {
    private int expectedDatasetSize;

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
        return false;
    }
}
