import org.junit.Assert;

import org.junit.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by J on 02-Nov-2014.
 */
public class TestDataBuilder {

    ArrayList<String[]> listOfArrays = new ArrayList<>();

    @Test
    public void New_DataBuilder_Accepts_ListOfStringArrays(){

        ArrayList<String[]> listOfArrays = new ArrayList<>();
        String[] array = {};
        String[] array2= {};

        listOfArrays.add(array);
        listOfArrays.add(array2);

        try {
            new DataBuilder(listOfArrays);
        } catch (InvalidInputDataException e) {
            fail(e.getMessage());
        }

    }

    @Ignore
    public void New_DataBuilder_Accepts_FileHandler(){

       InputHandler input = new InputHandler();

        new DataBuilder(input);
    }


    @Test
    public void DataBuilder_FetchData_returns_EmptyListIfNoValidData(){

        String[] array = {};
        listOfArrays.add(array);

        DataBuilder dataBuilder = null;
        try {
            dataBuilder = new DataBuilder(listOfArrays);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        List obj = dataBuilder.fetchDataValidDataObject();

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
    public void DataBuilder_FetchData_returns_List(){

        String[] array = {};
        listOfArrays.add(array);


        DataBuilder dataBuilder = null;
        try {
            dataBuilder = new DataBuilder(listOfArrays);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        Object obj = dataBuilder.fetchDataValidDataObject();

        assertThat(obj, instanceOf(ArrayList.class));
    }

    @Test
    public void DataBuilder_FetchData_returns_List_With_DataObject(){

        DataBuilder dataBuilder = null;


    }

    @Test
    public void DataBuilder_FetchData_List_Without_Duplicate_DataObject(){

        DataBuilder dataBuilder = null;


    }


}
