/**
 * Created by James on 14/10/2014.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

@RunWith(MockitoJUnitRunner.class)
public class TestMarket {

    //DataValidator dataValidator = new DataValidator(1, validationData);
    DataObject mockedData = mock(DataObject.class);

    @Before
    public void setUp(){

        stub(mockedData.getSymbol()).toReturn("TSCO");
        stub(mockedData.getCompany_name()).toReturn("Tesco");
        stub(mockedData.getIndustry()).toReturn("XXX");
        stub(mockedData.getIsin()).toReturn("XXX");

    }

    @Mock
    DataValidator dataValidator;

    @Mock
    PersistenceHandler jsonhandler;

    Market market = new Market();
    ArrayList<String[]> listOfArrays = new ArrayList<>();



    @Test
    public void Create_New_Company_and_Add_to_Companies(){

        Market ftse = new Market();
        Company company = new Company(mockedData,new Date());

        Assert.assertEquals(0,ftse.getNoOfCompanies());

        ftse.AddCompany(company);

        Assert.assertEquals(1, ftse.getNoOfCompanies());

    }

    @Test
    public void New_Data_Adds_New_Companies_Only(){

        Market ftse = new Market();
        Company company = new Company(mockedData,new Date(114,1,3));
        Company company2 = new Company(mockedData,new Date(114,1,2));

        Assert.assertEquals(0,ftse.getNoOfCompanies());

        ftse.AddCompany(company);
        ftse.AddCompany(company2);

        Assert.assertEquals(1, ftse.getNoOfCompanies());
    }


    @Test
      public void Market_Find_Company_By_Symbol(){

        stub(mockedData.getSymbol()).toReturn("TEST");

        Market ftse = new Market();

        Company company = new Company(mockedData,new Date());

        Assert.assertNull(ftse.FindBySymbol("TEST"));

        ftse.AddCompany(company);

        Assert.assertEquals(company, ftse.FindBySymbol("TEST"));

    }

    @Test
    public void Market_Sort_Companies(){

        Market ftse = new Market();

        stub(mockedData.getSymbol()).toReturn("TESTT");
        Company company1 = new Company(mockedData,new Date());

        stub(mockedData.getSymbol()).toReturn("TEST");
        Company company2 = new Company(mockedData,new Date());

        stub(mockedData.getSymbol()).toReturn("TESTA");
        Company company3 = new Company(mockedData,new Date());

        ftse.AddCompany(company1);
        ftse.AddCompany(company2);
        ftse.AddCompany(company3);

        ftse.sortCompaniesBySymbol();

        Assert.assertEquals(company2, ftse.GetListOfCompanies().get(0));

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


}
