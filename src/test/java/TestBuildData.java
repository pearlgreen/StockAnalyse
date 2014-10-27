/**
 * Created by James on 14/10/2014.
 */

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;


public class TestBuildData {


    @Test
    public void Company_Returns_Null_For_No_Data_At_Date(){


        RawData testData = new RawData();
        testData._companyName="The Test Company";
        testData._sector="Sector X";
        testData._symbol="XXX";

        Company company = new Company(testData,new GregorianCalendar().get(Calendar.DATE));

        Assert.assertEquals(null,company.fetchDataForDate(new GregorianCalendar(1900,1,1).get(Calendar.DATE)));

    }

    @Test
    public void Create_New_Company_and_Add_to_Companies(){

        RawData testData = new RawData();
        testData._companyName="The Test Company";
        testData._sector="Sector X";
        testData._symbol="XXX";

        Market ftse = new Market();
        Company company = new Company(testData,new GregorianCalendar().get(Calendar.DATE));

        ftse.AddCompany(company);

        Assert.assertEquals(company.getCompanySymbol(),"XXX");
        Assert.assertEquals(ftse.FindBySymbol("XXX"),company);

    }

    @Test
    public void New_Data_Adds_New_Companies_Only(){

        Market marketToTest = new Market();

        List<RawData> listOfData = new ArrayList<RawData>();

        RawData testData1 = new RawData();
        testData1._companyName="The Test Company";
        testData1._sector="Sector X";
        testData1._symbol="XXX";

        RawData testData2 = new RawData();
        testData2._companyName="The Test Company";
        testData2._sector="Sector X";
        testData2._symbol="XXX";

        RawData testData3 = new RawData();
        testData3._companyName="The Test Company";
        testData3._sector="Sector Y";
        testData3._symbol="YYY";

        listOfData.add(testData1);
        listOfData.add(testData2);
        listOfData.add(testData3);
        listOfData.add(testData3);

        int companiesAdded = marketToTest.generateFromNewExtraction(listOfData);

        Assert.assertEquals(2,companiesAdded);
        Assert.assertEquals(2,marketToTest.getNoOfCompanies());

             }

    @Test
    public void New_CompanyData_Added(){

        Market marketToTest = new Market();

        List<RawData> listOfData = new ArrayList<RawData>();

        RawData testData1 = new RawData();
        testData1._companyName="The Test Company";
        testData1._sector="Sector X";
        testData1._symbol="XXX";
        testData1._marketCap=123.45;
        listOfData.add(testData1);


        marketToTest.generateFromNewExtraction(listOfData);
        CompanyData actualData = marketToTest.FindBySymbol("XXX").fetchDataForDate(new GregorianCalendar().get(Calendar.DATE));


        CompanyData expectedData = new CompanyData(testData1, new GregorianCalendar().get(Calendar.DATE));

        Assert.assertEquals(expectedData.getDate(),actualData.getDate());
        Assert.assertEquals(expectedData.getMarketCap(),actualData.getMarketCap(),0);

    }


}
