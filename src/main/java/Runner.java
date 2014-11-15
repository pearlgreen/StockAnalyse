import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * Created by J on 11-Oct-2014.
 */

public class Runner  {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, URISyntaxException, XPathExpressionException {

        StockAnalyser test = new StockAnalyser();

        test.initialise();
        test.writeToFile();
       // test.generateForDate(new Date(System.currentTimeMillis()));


    }
}