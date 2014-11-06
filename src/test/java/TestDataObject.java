import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringStartsWith;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by J on 03-Nov-2014.
 */
public class TestDataObject {


    final int DATASET_SIZE = 41;




    @Test
    public void DataObject_Returns_Error_When_String_Array_TooSmall() throws InvalidInputDataException {

        String[] array = new String[DATASET_SIZE-1];


        try{
            DataObject dataObject = new DataObject(array);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e){
            assertThat(e, instanceOf(InvalidInputDataException.class));
            Assert.assertTrue(e.getErrorMessage().contains("Input data array is of size"));
        }


    }


    @Test
    public void DataObject_Returns_Error_When_String_Array_TooLarge() throws InvalidInputDataException {

        String[] array = new String[DATASET_SIZE+1];

        try{
            DataObject dataObject = new DataObject(array);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e){
            assertThat(e, instanceOf(InvalidInputDataException.class));
            Assert.assertTrue(e.getErrorMessage().contains("Input data array is of size"));
        }


    }


    @Test
    public void DataObject_Parses_And_Returns_Error_For_Invalid_Symbol(){

        String[] array = new String[DATASET_SIZE];
        array[0]="";

        try{
            DataObject dataObject = new DataObject(array);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e){
            assertThat(e, instanceOf(InvalidInputDataException.class));
            Assert.assertTrue(e.getErrorMessage().contains("Input data is invalid/empty at SYMBOL_COLUMN"));
        }


    }

}
