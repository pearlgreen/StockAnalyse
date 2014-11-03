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

    String[] valid_data = {"TSCO","Tesco","14292.4","14.58","8122.99","8.39","0.82","3.55","0.06","4.49","1","6.86","27029.4",
            "","3185","7.54","1.03","0.88","1.53","683.77","","32936","-188.65","7.29","27.81","0.22","387","63557","20206","14043",
            "2506","3795","2487","9190","-2447","134.43","20140222","GB0008847096","175.95","FOOD & DRUG RETAILERS","974"};


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
    @Test
    public void DataBuilder_Parses_And_Sets_Correct_Data() {

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
       // smallerListOfArrays.add(valid_data);

        DataBuilder dataBuilder =null;
        DataObject dataObjectUT = null;
        try {
            dataBuilder = new DataBuilder(smallerListOfArrays);
            List<DataObject> dataObjects = dataBuilder.fetchDataValidDataObject();
            dataObjectUT = dataObjects.get(0);

        } catch (InvalidInputDataException e) {
            System.out.println(e.getErrorMessage());
            fail(e.getErrorMessage());
        }

        Assert.assertEquals("TSCO", dataObjectUT.getSymbol());
        Assert.assertEquals(7.54, dataObjectUT.getRoce());


    }

}
