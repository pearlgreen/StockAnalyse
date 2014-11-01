import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by J on 29-Oct-2014.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestJSonParsing {

    @Mock
    PersistenceHandler jsonhandler;

    @Test
    public void TestThatCompanyObjectWrittenAndReadFromJSON() {


        Company company = new Company(new RawData(),20140101);
        company.setCompanySymbol("TEST");
        company.setCompanyName("TESTNAME");

        Market market = new Market();
        market.AddCompany(company);

        market.SetPersistence(jsonhandler);
        market.SaveMarkets("ftse");

        Mockito.verify(jsonhandler,Mockito.times(1)).SaveMarketData(Mockito.anyListOf(Company.class), Mockito.eq("ftse"));

    }


    @Test
    public void tess() {


        Market market = new Market();
        market.SetPersistence(jsonhandler);

        market.LoadCompanies("ftse");

        try {
            Mockito.verify(jsonhandler,Mockito.times(1)).getMarketData(Mockito.eq("ftse"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
