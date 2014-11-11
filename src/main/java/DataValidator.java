import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 07/11/2014.
 */
public class   DataValidator {


    private int expectedDatasetSize;
    private ArrayList<DataStructure> validationStructure;


    public DataValidator(int _expectedDatasetSize, ArrayList<DataStructure> _validationStructure){
        this.expectedDatasetSize = _expectedDatasetSize;
        this.validationStructure = _validationStructure;
    }


    public boolean validateFields(String[] array) {

        for(int i=0;i<array.length;i++) {

            String content = array[i];

            for (DataStructure e : validationStructure) {
                if (i == e.getIndex()) {
                    if (e.isShouldNotBeNull() && content.isEmpty()) return false;
                }
            }
        }

        return true;
    }






    public int getExpectedDatasetSize() {
        return expectedDatasetSize;
    }

    public boolean validDatasetSize(String[] inputArray) {

        if (expectedDatasetSize ==inputArray.length)  return true;
        return false;

            }


}
