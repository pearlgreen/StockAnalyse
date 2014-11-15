

import au.com.bytecode.opencsv.CSVReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


public class StockAnalyser{

    private  List<DataObject>  stockData;
    private Market market;
    List headers;


    public StockAnalyser() throws SAXException, IOException, URISyntaxException, XPathExpressionException, ParserConfigurationException {

    market = new Market();

    }

    public List getStockData(){

        return this.stockData;

    }


    public void setStockData(List<DataObject> listInput){

        this.stockData = listInput;
    }


    public void initialise() throws URISyntaxException, IOException {
        URL url = new URL("http://uk.advfn.com/p.php?pid=filterxdownload&show=1_1_,1_4_,1_2_,1_5_,1_8_,1_10_,1_27_,2_8_,2_18_,2_14_,2_62_,2_78_,3_30_,2_21_,2_45_,2_57_,2_23_,1_12_,1_13_,1_14_,1_87_,1_66_,1_20_,2_9_,3_32_,3_3_,3_16_,3_17_,3_7_,3_12_,3_8_,3_9_,1_17_,1_24_,1_29_,1_52_,1_44_,1_53_,3_4_&sort=3_32_D&cnstr=&zip=0");
        File file = new File("C:\\Users\\Public\\Documents\\temp.csv");
        org.apache.commons.io.FileUtils.copyURLToFile(url, file);
        CSVReader parser = new CSVReader(new FileReader(file));

        stockData = new ArrayList<DataObject>();
        List<String[]> tmp = (ArrayList) parser.readAll();
        ArrayList<DataStructure> columnDefinition = new ArrayList<DataStructure>();

        //columnDefinition.add(new DataStructure(0,""));

        DataValidator dataValidator = new DataValidator(columnDefinition);

        DataBuilder builder = null;
        try {
            builder = new DataBuilder(tmp,dataValidator);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        stockData = builder.fetchDataValidDataObjects();

        //headers =  stockData.get(0);
       // stockData.remove(headers);
        //market.generateFromNewExtraction(stockData);


    }


    // every list of data
    // if company symbol is new, then create Company
    // if data date for Company is new, add new CompanyData



  /*  String getPageTest(String fileName, String companyName) throws SAXException, IOException, XPathExpressionException, ParserConfigurationException {

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

    }*/


    public void writeToFile() throws IOException {

        market.SaveMarkets("ftse");


           }


}



