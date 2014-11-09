import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.stub;

/**
 * Created by J on 03-Nov-2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestDataObject {


    @Mock
    DataValidator mockedDataValidator;

    @Test
    public void DataObject_Returns_Error_When_String_Array_IncorrectSizeSmall() throws InvalidInputDataException {

        String[] array = new String[29];

        stub(mockedDataValidator.validDatasetSize(array)).toReturn(false);
        stub(mockedDataValidator.getExpectedDatasetSize()).toReturn(30);

        try{
            DataObject dataObject = new DataObject(array, mockedDataValidator);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e){

            Mockito.verify(mockedDataValidator).validDatasetSize(array);
            assertThat(e, instanceOf(InvalidInputDataException.class));
            Assert.assertTrue(e.getErrorMessage().contains("Input data array is of incorrect size: 29 and not the required 30"));
        }

    }


    @Test
    public void DataObject_Returns_Error_When_String_Array_IncorrectSizeLarge() throws InvalidInputDataException {

        String[] array = new String[31];

        stub(mockedDataValidator.validDatasetSize(array)).toReturn(false);
        stub(mockedDataValidator.getExpectedDatasetSize()).toReturn(30);

        try{
            DataObject dataObject = new DataObject(array, mockedDataValidator);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e){

            Mockito.verify(mockedDataValidator).validDatasetSize(array);
            assertThat(e, instanceOf(InvalidInputDataException.class));
            Assert.assertTrue(e.getErrorMessage().contains("Input data array is of incorrect size:"));
        }

    }


    @Test
    public void DataObject_Parses_And_Returns_Error_For_Missing_Symbol(){

        String[] array = new String[1];

        stub(mockedDataValidator.validCriticalFields(array)).toReturn(false);

        try{
            DataObject dataObject = new DataObject(array, mockedDataValidator);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e){

            Mockito.verify(mockedDataValidator).validDatasetSize(array);
            assertThat(e, instanceOf(InvalidInputDataException.class));
            Assert.assertTrue(e.getErrorMessage().contains("Input data is invalid/empty at SYMBOL_COLUMN"));
        }



    }

}
