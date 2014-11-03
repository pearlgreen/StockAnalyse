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


    private static final int SYMBOL = 1;
    private static final int NAME_COLUMN=2;
    private static final int MARKET_CAP_COLUMN=3;
    private static final int PERATIO_COLUMN=4;
    private static final int SHARES_COLUMN=5;
    private static final int DIVYIELD_COLUMN=6;
    private static final int DIVCOVER_COLUMN=7;
    private static final int OPMARGIN_COLUMN=8;
    private static final int SPREAD=9;
    private static final int PRICETOCASH=10;
    private static final int EARNDROPS10=11;
    private static final int EARNSYIELD=12;
    private static final int ENTVALUE=13;
    private static final int FIVEYRGRTH=14;
    private static final int OPERATIONS=15;
    private static final int ROCE=16;
    private static final int DBTEQUITY=17;
    private static final int CURRENT=18;
    private static final int NETMARGIN=19;
    private static final int EARNGWTH=20;
    private static final int DIVGWTH=21;
    private static final int NETDEBT=22;
    private static final int ONEYRCHNG=23;
    private static final int CHNGLOW=24;
    private static final int PRETAXPFT=25;
    private static final int PRCTOSALES=26;
    private static final int RETAINCASH=27;
    private static final int TURNOVER=28;
    private static final int CREDITSHRT=29;
    private static final int CREDITLONG=30;
    private static final int CASHEQUIV=31;
    private static final int INTANGBLES=32;
    private static final int CURRENTASSTS=33;
    private static final int DEBTORS=34;
    private static final int NETWKNGCAPIT=35;
    private static final int NTTANGASSTVL=36;
    private static final int RSLTPRDDATE=37;
    private static final int ISIN=38;
    private static final int LATEST_PRICE=39;
    private static final int INDUSTRY=40;
    private static final int ATTRIB_PRFT=41;


    final int DATASET_SIZE = 41;

    String[] array = new String[DATASET_SIZE];
    List<String[]> listOfArrays = new ArrayList<String[]>();

    String[] default_data = {"TSCO","Tesco","14292.4","14.58","8122.99","8.39","0.82","3.55","0.06","4.49","1","6.86","27029.4",
            "","3185","7.54","1.03","0.88","1.53","683.77","","32936","-188.65","7.29","27.81","0.22","387","63557","20206","14043",
            "2506","3795","2487","9190","-2447","134.43","20140222","GB0008847096","175.95","FOOD & DRUG RETAILERS","974"};



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

        Object obj = dataBuilder.fetchDataValidDataObject();

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
    public void DataBuilder_Parses_And_Sets_Correct_Data() {

        List<String[]> smallerListOfArrays = new ArrayList<String[]>();
        smallerListOfArrays.add(default_data);

        DataBuilder dataBuilder =null;
        RawData dataObjectUT = null;
        try {
            dataBuilder = new DataBuilder(smallerListOfArrays);
            List<RawData> dataObjects = dataBuilder.fetchDataValidDataObject();
            dataObjectUT = dataObjects.get(0);

        } catch (InvalidInputDataException e) {
            System.out.println(e.getErrorMessage());
            fail(e.getErrorMessage());
        }

        Assert.assertEquals("TSCO", dataObjectUT.getSymbol());
        Assert.assertEquals(7.54, dataObjectUT.getRoce());


    }

    @Test
    public void DataBuilder_Parses_And_Returns_Error_For_Invalid_Symbol(){

        String[] array1 = new String[DATASET_SIZE];

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
