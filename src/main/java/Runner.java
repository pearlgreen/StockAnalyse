import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by J on 11-Oct-2014.
 */

public class Runner  {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, URISyntaxException, XPathExpressionException {
        BuildData test = new BuildData();

        test.initialise();
        test.filterAndSortData(3);


    }
}