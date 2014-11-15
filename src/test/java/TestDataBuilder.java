import org.junit.Assert;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

/**
 * Created by J on 02-Nov-2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestDataBuilder {

    ArrayList<String[]> listOfArrays = new ArrayList<>();

    String[] valid_data = {"TSCO","Tesco","14292.4","14.58","8122.99","8.39","0.82","3.55","0.06","4.49","1","6.86","27029.4",
            "","3185","7.54","1.03","0.88","1.53","683.77","","32936","-188.65","7.29","27.81","0.22","387","63557","20206","14043",
            "2506","3795","2487","9190","-2447","134.43","20140222","GB0008847096","175.95","FOOD & DRUG RETAILERS","974"};

    @Mock
    ArrayList<DataStructure> stubDataStructures;

    DataValidator dataValidator = new DataValidator(new ArrayList<DataStructure>(41));


    @Mock
    DataValidator stubbedDataValidator;

    @Test
    public void New_DataBuilder_Accepts_ListOfStringArrays(){

        ArrayList<String[]> listOfArrays = new ArrayList<>();
        String[] array = {};
        String[] array2= {};

        listOfArrays.add(array);
        listOfArrays.add(array2);

        try {
            new DataBuilder(listOfArrays,stubbedDataValidator);
        } catch (InvalidInputDataException e) {
            fail(e.getMessage());
        }

    }

    @Ignore
    public void New_DataBuilder_Accepts_FileHandler(){

       InputHandler input = new InputHandler();


        new DataBuilder(input,stubbedDataValidator);
    }


    @Test
    public void DataBuilder_FetchData_returns_EmptyListIfNoValidData(){

        String[] array = {};
        listOfArrays.add(array);

        DataBuilder dataBuilder = null;
        try {
            dataBuilder = new DataBuilder(listOfArrays,stubbedDataValidator);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        List obj = dataBuilder.fetchDataValidDataObjects();

    //    Mockito.verify(stubbedDataValidator.validDatasetSize(array));
        Assert.assertEquals(true, obj.isEmpty());

    }


    @Test
    public void DataBuilder_FetchData_returns_ExceptionIfListOfArraysIsEmpty(){

        DataBuilder dataBuilder = null;

        try {
            dataBuilder = new DataBuilder(new ArrayList<String[]>(),stubbedDataValidator);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e) {
            assertThat(e, instanceOf(InvalidInputDataException.class));
        }

    }


    @Test
    public void DataBuilder_FetchData_returns_List(){

        String[] array = {};
        listOfArrays.add(array);
        stub(stubbedDataValidator.getExpectedDatasetSize()).toReturn(1);


        DataBuilder dataBuilder = null;


        try {
            dataBuilder = new DataBuilder(listOfArrays,stubbedDataValidator);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        Object obj = dataBuilder.fetchDataValidDataObjects();

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


    @Test
    public void DataBuilder_Parses_And_Returns_ArrayList_Object() {

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
         smallerListOfArrays.add(valid_data);
        DataBuilder dataBuilder=null;

        DataValidator dataValidator = mock(DataValidator.class);
        when(dataValidator.validDatasetSize(valid_data)).thenReturn(true);
        when(dataValidator.validateFields(valid_data)).thenReturn(false);


       // DataValidator dataValidator = new DataValidator(stubDataStructures);

        DataObject dataObjectUT = null;
        try {
             dataBuilder = new DataBuilder(smallerListOfArrays,dataValidator);

        } catch (InvalidInputDataException e) {
            System.out.println(e.getErrorMessage());
            fail(e.getErrorMessage());
        }


        List dataObject = dataBuilder.fetchDataValidDataObjects();

        Assert.assertThat(dataObject,is(ArrayList.class));
        Assert.assertTrue(dataObject.isEmpty());

    }

    @Test
    public void DataBuilder_Parses_And_Returns_TSCO_Data_Object() {

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
        smallerListOfArrays.add(valid_data);
        DataBuilder dataBuilder=null;




        DataObject dataObjectUT = null;
        try {
            dataBuilder = new DataBuilder(smallerListOfArrays,dataValidator);

        } catch (InvalidInputDataException e) {
            System.out.println(e.getErrorMessage());
            fail(e.getErrorMessage());
        }


        List<DataObject> dataObjects = dataBuilder.fetchDataValidDataObjects();

        dataObjectUT = dataObjects.get(0);

        Assert.assertEquals("TSCO", dataObjectUT.getSymbol());
        Assert.assertEquals(7.54, dataObjectUT.getRoce(),0);


    }



}
