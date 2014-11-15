import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * Created by J on 02-Nov-2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestDataBuilder {

    ArrayList<String[]> listOfArrays = new ArrayList<>();

    String[] valid_data = {"1","TSCO", "Tesco", "14292.4", "14.58", "8122.99", "8.39", "0.82", "3.55", "0.06", "4.49", "1", "6.86", "27029.4",
            "", "3185", "7.54", "1.03", "0.88", "1.53", "683.77", "", "32936", "-188.65", "7.29", "27.81", "0.22", "387", "63557", "20206", "14043",
            "2506", "3795", "2487", "9190", "-2447", "134.43", "20140222", "GB0008847096", "175.95", "FOOD & DRUG RETAILERS", "974"};

    @Mock
    ArrayList<DataStructure> stubDataStructures;

    DataValidator dataValidator;


    @Mock
    DataValidator stubbedDataValidator;

    @Test
    public void New_DataBuilder_Accepts_ListOfStringArrays() {

        ArrayList<String[]> listOfArrays = new ArrayList<>();
        String[] array = {};
        String[] array2 = {};

        listOfArrays.add(array);
        listOfArrays.add(array2);

        try {
            new DataBuilder(listOfArrays, stubbedDataValidator);
        } catch (InvalidInputDataException e) {
            fail(e.getMessage());
        }

    }

    @Ignore
    public void New_DataBuilder_Accepts_FileHandler() {

        InputHandler input = new InputHandler();


        new DataBuilder(input, stubbedDataValidator);
    }


    @Test
    public void DataBuilder_FetchData_returns_EmptyListIfNoValidData() {

        String[] array = {};
        listOfArrays.add(array);

        DataBuilder dataBuilder = null;
        try {
            dataBuilder = new DataBuilder(listOfArrays, stubbedDataValidator);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        List obj = dataBuilder.fetchDataValidDataObjects();

        //    Mockito.verify(stubbedDataValidator.validDatasetSize(array));
        Assert.assertEquals(true, obj.isEmpty());

    }


    @Test
    public void DataBuilder_FetchData_returns_ExceptionIfListOfArraysIsEmpty() {

        DataBuilder dataBuilder = null;

        try {
            dataBuilder = new DataBuilder(new ArrayList<String[]>(), stubbedDataValidator);
            fail("Should have thrown InvalidInputDataException");
        } catch (InvalidInputDataException e) {
            assertThat(e, instanceOf(InvalidInputDataException.class));
        }

    }


    @Test
    public void DataBuilder_FetchData_returns_List() {

        String[] array = {};
        listOfArrays.add(array);
        stub(stubbedDataValidator.getExpectedDatasetSize()).toReturn(1);


        DataBuilder dataBuilder = null;


        try {
            dataBuilder = new DataBuilder(listOfArrays, stubbedDataValidator);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        Object obj = dataBuilder.fetchDataValidDataObjects();

        assertThat(obj, instanceOf(ArrayList.class));
    }

    @Test
    public void DataBuilder_FetchData_returns_List_With_DataObject() {

        DataBuilder dataBuilder = null;


    }

    @Test
    public void DataBuilder_FetchData_List_Without_Duplicate_DataObject() {

        DataBuilder dataBuilder = null;


    }


    @Test
    public void DataBuilder_Parses_And_Returns_ArrayList_Object() {

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
        smallerListOfArrays.add(valid_data);
        DataBuilder dataBuilder = null;

        DataValidator dataValidator = mock(DataValidator.class);
        when(dataValidator.validDatasetSize(valid_data)).thenReturn(true);
        when(dataValidator.validateFields(valid_data)).thenReturn(false);


        // DataValidator dataValidator = new DataValidator(stubDataStructures);

        DataObject dataObjectUT = null;
        try {
            dataBuilder = new DataBuilder(smallerListOfArrays, dataValidator);

        } catch (InvalidInputDataException e) {
            System.out.println(e.getErrorMessage());
            fail(e.getErrorMessage());
        }


        List dataObject = dataBuilder.fetchDataValidDataObjects();

        Assert.assertThat(dataObject, is(ArrayList.class));
        Assert.assertTrue(dataObject.isEmpty());

    }

    @Test
    public void DataBuilder_Parses_And_Returns_TSCO_Data_Object() {

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();

         smallerListOfArrays.add(valid_data);
        DataBuilder dataBuilder = null;

        ArrayList<DataStructure> columns = new ArrayList<DataStructure>();

        columns.add(new DataStructure(0, "", false));
        columns.add(new DataStructure(1, "Symbol", true));
        columns.add(new DataStructure(2, "Name", true));
        columns.add(new DataStructure(3, "Market cap. (m)", true));
        columns.add(new DataStructure(4, "PE ratio", false));
        columns.add(new DataStructure(5, "Shares in issue (m)", false));
        columns.add(new DataStructure(6, "Dividend yield", false));
        columns.add(new DataStructure(7, "Dividend cover", false));
        columns.add(new DataStructure(8, "Operating margin (%)", false));
        columns.add(new DataStructure(9, "Spread (%)", false));
        columns.add(new DataStructure(10, "Price To cash Flow PS", false));
        columns.add(new DataStructure(11, "No of 5% Earnings drops in last 10yr", false));
        columns.add(new DataStructure(12, "Earnings Yield", false));
        columns.add(new DataStructure(13, "Enterprise Value", false));
        columns.add(new DataStructure(14, "5 year Compound Earnings Growth", false));
        columns.add(new DataStructure(15, "Operations (m)", false));
        columns.add(new DataStructure(16, "Return On Capital Employed (ROCE)", false));
        columns.add(new DataStructure(17, "Debt To Equity Ratio", false));
        columns.add(new DataStructure(18, "Current ratio", false));
        columns.add(new DataStructure(19, "Net Profit Margin", false));
        columns.add(new DataStructure(20, "Earnings PS - growth rate", false));
        columns.add(new DataStructure(21, "Dividend PS growth rate", false));
        columns.add(new DataStructure(22, "Net Debt(m)", false));
        columns.add(new DataStructure(23, "Change from 1Yr Open Price", false));
        columns.add(new DataStructure(24, "Change from low - year", false));
        columns.add(new DataStructure(25, "Pre-Tax Profit PS", false));
        columns.add(new DataStructure(26, "Price To Sales", false));
        columns.add(new DataStructure(27, "Retained cash (m)", false));
        columns.add(new DataStructure(28, "Turnover (m)", false));
        columns.add(new DataStructure(29, "Creditors; short (m)", false));
        columns.add(new DataStructure(30, "Creditors; long (m)", false));
        columns.add(new DataStructure(31, "Cash & equivalents (m)", false));
        columns.add(new DataStructure(32, "Intangibles (m)", false));
        columns.add(new DataStructure(33, "Current assets - other (m)", false));
        columns.add(new DataStructure(34, "Debtors (m)", false));
        columns.add(new DataStructure(35, "Net Working Capital (m)", false));
        columns.add(new DataStructure(36, "Net tangible asset value PS", false));
        columns.add(new DataStructure(37, "Result period end date", false));
        columns.add(new DataStructure(38, "ISIN", false));
        columns.add(new DataStructure(39, "Last trade price", false));
        columns.add(new DataStructure(40, "Industry name", false));
        columns.add(new DataStructure(41, "Attributable Profit", false));

        dataValidator = new DataValidator(columns);


        DataObject dataObjectUT = null;
        try {
            dataBuilder = new DataBuilder(smallerListOfArrays, dataValidator);

        } catch (InvalidInputDataException e) {
            System.out.println(e.getErrorMessage());
            fail(e.getErrorMessage());
        }


        List<DataObject> dataObjects = dataBuilder.fetchDataValidDataObjects();

        dataObjectUT = dataObjects.get(0);

        Assert.assertEquals("TSCO", dataObjectUT.getSymbol());
        Assert.assertEquals(7.54, dataObjectUT.getRoce(), 0);
        Assert.assertEquals(8122.99,dataObjectUT.getShares(),0);
        Assert.assertEquals(14.58,dataObjectUT.getPe_ratio(),0);


    }


}
