/**
 * Created by James on 14/10/2014.
 */

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.io.IOException;
import java.util.*;


public class TestMarket {

    //DataValidator dataValidator = new DataValidator(1, validationData);

    @Mock
    DataValidator dataValidator;

    @Mock
    PersistenceHandler jsonhandler;

    Market market = new Market();
    ArrayList<String[]> listOfArrays = new ArrayList<>();

    @Test
    public void Build_Raw_Data_From_String_Array(){

       String [] string_array = new String [3];
       string_array[0]="company_name";
       string_array[0]="bbb";
       string_array[0]="ccc";



        DataObject dataObject = null;
        try {
            dataObject = new DataObject(string_array, dataValidator);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("company_name", dataObject.getCompany_name());

}


    @Test
    public void Validate_RawData_Object(){



    }


    @Test
    public void Cannot_Build_Raw_Data(){


    }


    @Test
    public void Company_Returns_Null_For_No_Data_At_Date(){


       // DataObject testData = new DataObject();
        //testData.setCompany_name("The Test Company");
        //testData.setSector("Sector X");
        //testData.setSymbol("XXX");

       // Company company = new Company(testData,new GregorianCalendar().get(Calendar.DATE));

        //CompanyData data = company.fetchDataForDate(19000101);

        //Assert.assertNull(data);

    }

    @Test
    public void Create_New_Company_and_Add_to_Companies(){


       // DataObject testData = new DataObject();
       // testData.setCompany_name("The Test Company");
       // testData.setSector("Sector X");
       // testData.setSymbol("XXX");

        Market ftse = new Market();
        Company company = new Company(null,new Date());

        ftse.AddCompany(company);

        Assert.assertEquals(company.getCompanySymbol(),"XXX");
        Assert.assertEquals(ftse.FindBySymbol("XXX"),company);

    }

    @Test
    public void New_Data_Adds_New_Companies_Only(){

        Market marketToTest = new Market();

        List<DataObject> listOfData = new ArrayList<DataObject>();

      //  String[] valid_data = {"1","TSCO", "Tesco");



      //  DataObject testData1 = new DataObject(valid_data,new DataValidator(new DataStructure(0,"test3",false)));


        // DataObject testData2 = new DataObject();
        //testData2._companyName="The Test Company";
        //testData2._sector="Sector X";
        //testData2._symbol="XXX";

        // DataObject testData3 = new DataObject();
        //testData3._companyName="The Test Company";
        //testData3._sector="Sector Y";
        //testData3._symbol="YYY";

      //  listOfData.add(testData1);
       // listOfData.add(testData2);
        //listOfData.add(testData3);

        int companiesAdded = marketToTest.buildCompanies(listOfData);


        Assert.assertEquals(2, companiesAdded);
        Assert.assertEquals(2,marketToTest.getNoOfCompanies());

             }



    @Test
    public void New_CompanyData_Added(){

        Market marketToTest = new Market();

        List<DataObject> listOfData = new ArrayList<DataObject>();

        // DataObject testData1 = new DataObject();
        try {
            DataBuilder dataBuilder=new DataBuilder(listOfArrays,dataValidator);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }


        //  listOfData.add(testData1);


        marketToTest.buildCompanies(listOfData);
        CompanyData actualData = marketToTest.FindBySymbol("XXX").fetchDataForDate(new Date());

        //     CompanyData expectedData = new CompanyData(testData1, new GregorianCalendar().get(Calendar.DATE));

        //  Assert.assertEquals(expectedData.getDate(),actualData.getDate());
        //   Assert.assertEquals(expectedData.getMarketCap(),actualData.getMarketCap(),0);

    }




    @Test
    public void MarketCallsPersistenceHandler_method_called_when_Market_saved() {


        //Company company = new Company(new DataObject(),20140101);
        // company.setCompanySymbol("TEST");
        // company.setCompanyName("TESTNAME");

        Market market = new Market();
        //  market.AddCompany(company);

        market.SetPersistence(jsonhandler);
        market.SaveMarkets("ftse");

        Mockito.verify(jsonhandler, Mockito.times(1)).SaveMarketData(Mockito.any(Market.class), Mockito.eq("ftse"));

    }


    @Test
    public void Test_That_PersistenceHandler_method_called_when_Market_saved() {


        Market market = new Market();

          //  market.SetPersistence(jsonhandler);
           // market.SaveMarkets("ftse");


        try {
            Mockito.verify(jsonhandler,Mockito.times(1)).getMarket(Mockito.eq("ftse"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
