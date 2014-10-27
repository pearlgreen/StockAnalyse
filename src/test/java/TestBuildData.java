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
import java.util.ArrayList;


public class TestBuildData {


    @Test
    public void create_New_Company_and_add_to_Companies(){

        Companies companies = new Companies();
        Company company = new Company("XXX","The XXX Company", "Sector X");

        companies.AddCompany(company);

        Assert.assertEquals(company.getCompanySymbol(),"XXX");
        Assert.assertEquals(companies.FindBySymbol("XXX"),company);

    }




    @Test
    public void testListIsFilteredCorrectly(){


    }


    @Test
    public void testRawDataSetRemainsUnchangedAfterFilter(){

    }

}
