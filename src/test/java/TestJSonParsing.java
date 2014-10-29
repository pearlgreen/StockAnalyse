import org.junit.Assert;
import org.junit.Test;

/**
 * Created by J on 29-Oct-2014.
 */
public class TestJSonParsing {

    @Test
    public void TestThatCompanyObjectWrittenAndReadFromJSON() {

        Company company = new Company(new RawData(),20140101);
        company.setCompanySymbol("TEST");
        company.setCompanyName("TESTNAME");

        Market market = new Market();
        market.AddCompany(company);


       PersistenceHandler jsonhandler = new PersistenceHandler();
        market.SetPersistence(jsonhandler);

        market.SaveMarkets("ftse");

        Market newMarket = new Market();
        newMarket.SetPersistence(jsonhandler);

        newMarket.LoadCompanies("ftse");

        Company actualCompany = newMarket.FindBySymbol("TEST");

        Assert.assertEquals(company.getCompanyName(),actualCompany.getCompanyName());


    }


    @Test
    public void tess() {

        Company company = new Company(new RawData(),20140101);
        company.setCompanySymbol("TEST");
        company.setCompanyName("TESTNAME");

        Market market = new Market();
        market.AddCompany(company);


        PersistenceHandler jsonhandler = new PersistenceHandler();
        market.SetPersistence(jsonhandler);

        market.SaveMarkets("ftse");



    }


}
