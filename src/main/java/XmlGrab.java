
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.jsoup.parser.*;
import org.apache.commons.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;


public class XmlGrab{


public XmlGrab() throws SAXException, IOException, URISyntaxException, XPathExpressionException, ParserConfigurationException {
      getCSV();
}



    public void getCSV() throws URISyntaxException, IOException {


        URL url = new URL("http://uk.advfn.com/p.php?pid=filterxdownload&show=1_1_,1_4_,1_2_,1_5_,1_8_,1_11_,1_10_,1_27_,1_89_,2_8_,2_18_,2_14_,2_62_,2_78_,2_79_,3_28_,3_30_,2_27_,2_21_,2_22_,2_45_,2_57_,2_23_,1_12_,1_13_,1_14_,1_87_,1_66_,1_20_,2_9_,2_75_,3_32_&sort=3_32_D&cnstr=&zip=0");
        File file = new File("C:\\Users\\James\\Documents\\GitHub\\XmlGrab\\out\\temp.csv");
        org.apache.commons.io.FileUtils.copyURLToFile(url, file);
        CSVParser parser = CSVParser.parse(file, StandardCharsets.US_ASCII, CSVFormat.EXCEL);

        List list = parser.getRecords();
        System.out.println(list.size());

    }



    String getPageTest(String fileName, String companyName) throws SAXException, IOException, XPathExpressionException, ParserConfigurationException {

       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        String stringMaster = org.apache.commons.io.IOUtils.toString(new URL("http://uk.advfn.com/p.php?pid=financials&symbol=L^VTC"), "UTF-8");

        XmlTreeBuilder tree = new XmlTreeBuilder();
        Parser parseDoc = new Parser(tree);
        String xmlDoc = parseDoc.xmlParser().parseInput(stringMaster, "http://uk.advfn.com/p.php?pid=financials&symbol=L^VTC").toString();
        xmlDoc = xmlDoc.substring(xmlDoc.indexOf('\n')+1);
        xmlDoc = xmlDoc.replace("&nbsp","&#160;");

        org.w3c.dom.Document doc = db.parse(new InputSource(new StringReader(xmlDoc)));
        XPath xpath = XPathFactory.newInstance().newXPath();

        // XPath Query for showing all nodes value
        XPathExpression expr = xpath.compile("//tr[td='Debt Ratio']/td[position()=2]/text()");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);

        String test= String.valueOf(((NodeList) ((NodeList) result).item(0)));

        return test;

    }




}



