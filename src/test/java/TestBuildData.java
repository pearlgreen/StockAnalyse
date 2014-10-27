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
    public void Test_listIsCorrectlySorted() throws URISyntaxException, SAXException, ParserConfigurationException, XPathExpressionException, IOException {

        StockAnalyser testData = new StockAnalyser();

        ArrayList l = new ArrayList();

        ArrayList firstCompany = new ArrayList();
        firstCompany.add("2.0");
        firstCompany.add("3.0");

        ArrayList secondCompany = new ArrayList();
        secondCompany.add("2.5");
        secondCompany.add("2.5");

        ArrayList thirdCompany = new ArrayList();
        thirdCompany.add("2.1");
        thirdCompany.add("");

        // l.add(1,new CSVRecord().add(new Float(2.0)));

        l.add(firstCompany);
        l.add(secondCompany);
        l.add(thirdCompany);

        testData.setStockData(l);

        /*
        testData.sortData(0);
        Assert.assertEquals(testData.getStockData().get(0),firstCompany);

        testData.sortData(1);
        Assert.assertEquals(testData.getStockData().get(0),thirdCompany);

        testData = null;*/
    }

    @Test
    public void testListIsFilteredCorrectly(){


    }


    @Test
    public void testRawDataSetRemainsUnchangedAfterFilter(){

    }

}
