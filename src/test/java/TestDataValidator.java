import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

/**
 * Created by James on 11/11/2014.
 */
public class TestDataValidator {

    @Mock
    ArrayList<DataStructure> stubDataStructures;
    @Test
    public void DataValidator_ValidDatasetSize_sets_DatasetExpectedSize(){

        int expectedSize = 4;

        stubDataStructures = mock(ArrayList.class);
        when(stubDataStructures.size()).thenReturn(expectedSize);



        DataValidator dataValidator = new DataValidator(stubDataStructures);
        Assert.assertEquals(expectedSize, dataValidator.getExpectedDatasetSize());

    }

    @Test
    public void DataValidator_ValidDatasetSize_returns_true_when_dataset_is_expectedSize(){

        int expectedSize = 4;

        stubDataStructures = mock(ArrayList.class);
        when(stubDataStructures.size()).thenReturn(expectedSize);


        DataValidator dataValidator = new DataValidator(stubDataStructures);

        String [] arrayOfExpectedSize = new String[expectedSize];
        Assert.assertTrue(dataValidator.validDatasetSize(arrayOfExpectedSize));

    }

    @Test
    public void DataValidator_ValidDatasetSize_returns_false_when_dataset_is_smaller(){

        int expectedSize = 4;

        stubDataStructures = mock(ArrayList.class);
        when(stubDataStructures.size()).thenReturn(expectedSize);
        DataValidator dataValidator = new DataValidator(stubDataStructures);

        String [] arrayOfSmallerSize = new String[expectedSize-1];

        Assert.assertFalse(dataValidator.validDatasetSize(arrayOfSmallerSize));

    }

    @Test
    public void DataValidator_ValidDatasetSize_returns_false_when_dataset_is_larger(){

        int expectedSize = 4;


        stubDataStructures = mock(ArrayList.class);
        when(stubDataStructures.size()).thenReturn(expectedSize);
        DataValidator dataValidator = new DataValidator(stubDataStructures);

        String [] arrayOfLargerSize = new String[expectedSize+1];

        Assert.assertFalse(dataValidator.validDatasetSize(arrayOfLargerSize));

    }


    @Test
    public void DataValidator_ValidateFields_returns_false_when_Critical_field_is_missing_or_null(){

        ArrayList<DataStructure> validationData = new ArrayList<DataStructure>();
        validationData.add(new DataStructure(0, "Test Column", true));
        validationData.add(new DataStructure(1, "Test Column2", false));



        DataValidator dataValidator = new DataValidator(validationData);
        String [] arrayToValidate = {"","7.66"};

        Assert.assertFalse(dataValidator.validateFields(arrayToValidate));

    }

    @Test
    public void DataValidator_ValidateFields_returns_true_when_All_Critical_fields_are_present_but_missing_optionals(){


        ArrayList<DataStructure> validationData = new ArrayList<DataStructure>();
        validationData.add(new DataStructure(0, "Test Column1", true));
        validationData.add(new DataStructure(1, "Test Column2", false));


        DataValidator dataValidator = new DataValidator(validationData);
        String [] arrayToValidate = {"Test Row1",""};

        Assert.assertTrue(dataValidator.validateFields(arrayToValidate));

    }

    @Test

    public void DataValidator_ValidateFields_returns_true_when_All_fields_are_present(){

        ArrayList<DataStructure> validationData = new ArrayList<DataStructure>();
        validationData.add(new DataStructure(0, "Test Column1", true));
        validationData.add(new DataStructure(1, "Test Column2", false));


        DataValidator dataValidator = new DataValidator(validationData);
        String [] arrayToValidate = {"Test Row1","1.23"};

        Assert.assertTrue(dataValidator.validateFields(arrayToValidate));

    }


}
