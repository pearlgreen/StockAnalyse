import org.junit.Assert;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;

import javax.xml.crypto.Data;
import java.util.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by J on 02-Nov-2014.
 */
public class TestDataBuilder {

    @InjectMocks
    DataBuilder dataBuilderwithMocks;



    private static final int SYMBOL_COLUMN = 1;



    final int DATASET_SIZE = 31;

    String[] array = new String[DATASET_SIZE];
    List<String[]> listOfArrays = new ArrayList<String[]>();


    @Test
    public void New_DataBuilder_Accepts_StringArray(){


        try {
           new DataBuilder(array);
        } catch (Exception|InvalidInputDataException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void New_DataBuilder_Accepts_ListOfStringArrays(){


        listOfArrays.add(array);

        try {
            new DataBuilder(listOfArrays);
        } catch (Exception |InvalidInputDataException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void New_DataBuilder_Accepts_FileHandler(){

       InputHandler input = new InputHandler();

        try {
            new DataBuilder(input);
        } catch (Exception e) {
            fail(e.getMessage());
        }


    }


    @Test
    public void DataBuilder_FetchData_returns_ListOfRawData(){

        DataBuilder dataBuilder = null;
        try {
            dataBuilder = new DataBuilder(listOfArrays);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        Object obj = dataBuilder.fetchData();

        assertThat(obj, instanceOf(ArrayList.class));


    }

    @Test
    public void DataBuilder_FetchData_returns_EmptyListIfNoValidData(){

        DataBuilder dataBuilder = null;
        try {
            dataBuilder = new DataBuilder(new String[DATASET_SIZE]);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        List obj = dataBuilder.fetchData();

        Assert.assertEquals(true, obj.isEmpty());

    }


    @Test
    public void DataBuilder_FetchData_returns_ExceptionIfListOfArraysIsEmpty(){

        DataBuilder dataBuilder = null;
        try {
            dataBuilder = new DataBuilder(new ArrayList<String[]>());
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e) {
            assertThat(e, instanceOf(InvalidInputDataException.class));
        }

    }



    @Test

    public void DataBuilder_Returns_Error_When_String_Array_TooSmall() throws InvalidInputDataException {

        String[] array = new String[DATASET_SIZE-1];

            try{
                DataBuilder dataBuilder = new DataBuilder(array);
                fail("Should have thrown InvalidInputDataException");
            } catch (InvalidInputDataException e){
                assertThat(e, instanceOf(InvalidInputDataException.class));
            }


    }

    @Test
    public void DataBuilder_Returns_Error_When_At_Least_One_String_Array_TooSmall(){

        String[] array1 = new String[DATASET_SIZE];
        String[] array2= new String[DATASET_SIZE-1];

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
        smallerListOfArrays.add(array1);
        smallerListOfArrays.add(array2);

        try {
            DataBuilder dataBuilder = new DataBuilder(smallerListOfArrays);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e) {
            assertThat(e, instanceOf(InvalidInputDataException.class));
        }


    }


    @Test
    public void DataBuilder_Returns_Error_When_String_Array_TooLarge(){

        String[] array1 = new String[DATASET_SIZE];
        String[] array2= new String[DATASET_SIZE+1];

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
        smallerListOfArrays.add(array1);
        smallerListOfArrays.add(array2);

        try {
            DataBuilder dataBuilder = new DataBuilder(smallerListOfArrays);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e) {
            assertThat(e, instanceOf(InvalidInputDataException.class));
        }

    }
    @Test
    public void DataBuilder_Parses_And_Sets_Correct_Symbol(){

        String[] array1 = new String[DATASET_SIZE];
        array1[SYMBOL_COLUMN] = "XXX";

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
        smallerListOfArrays.add(array1);

        try {
            DataBuilder dataBuilderwithMocks = new DataBuilder(smallerListOfArrays);
        } catch (InvalidInputDataException e) {
            fail();
        }

       // Mockito.verify(dataBuilder).setSymbol("XXX");


    }

    @Test
    public void DataBuilder_Parses_And_Returns_Error_For_Invalid_Symbol(){

        String[] array1 = new String[DATASET_SIZE];
        array1[SYMBOL_COLUMN] = "";

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
        smallerListOfArrays.add(array1);

        try {
            DataBuilder dataBuilder = new DataBuilder(smallerListOfArrays);
            fail();
        } catch (InvalidInputDataException e) {
           assertThat(e,instanceOf(InvalidInputDataException.class));
        }

    }


    @Test
    public void DataBuilder_Parses_And_Returns_Correct_Name(){



    }
    @Test
    public void DataBuilder_Parses_And_Returns_Correct_MarketCap(){



    }

    @Test
    public void DataBuilder_Parses_And_Returns_Correct_NetProfitMargin(){


      /*  @Parameters
                ({"17, false",
                "22, true" })
        public void personIsAdult(int age, boolean valid) throws Exception {
            assertThat(new Person(age).isAdult(), is(valid));
        }
*/
    }

    @Test
    public void DataBuilder_FetchData_does_not_contain_duplicates(){



    }


}
