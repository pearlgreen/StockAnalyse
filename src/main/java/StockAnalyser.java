

import au.com.bytecode.opencsv.CSVReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


public class StockAnalyser{

    private List stockData;
    private Market companies;
    List headers;


    public StockAnalyser() throws SAXException, IOException, URISyntaxException, XPathExpressionException, ParserConfigurationException {

    companies = new Market();

    }

    public List getStockData(){

        return this.stockData;

    }


    public void setStockData(List<List> listInput){

        this.stockData = listInput;
    }


    public void initialise() throws URISyntaxException, IOException {
        URL url = new URL("http://uk.advfn.com/p.php?pid=filterxdownload&show=1_1_,1_4_,1_2_,1_5_,1_8_,1_11_,1_10_,1_27_,1_89_,2_8_,2_18_,2_14_,2_62_,2_78_,2_79_,3_28_,3_30_,2_27_,2_21_,2_22_,2_45_,2_57_,2_23_,1_12_,1_13_,1_14_,1_87_,1_66_,1_20_,2_9_,2_75_,3_32_&sort=3_32_D&cnstr=&zip=0");
        File file = new File("C:\\Users\\Public\\Documents\\temp.csv");
        org.apache.commons.io.FileUtils.copyURLToFile(url, file);
        CSVReader parser = new CSVReader(new FileReader(file));

        stockData = new ArrayList<RawData>();
        List<String[]> tmp = (ArrayList) parser.readAll();

        for(String[] c : tmp){

          stockData.add(Arrays.asList(c));

        }

        //headers =  stockData.get(0);
        stockData.remove(headers);

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

          JSONObject obj = new JSONObject();
       // obj.put("name", "mkyong.com");
       // obj.put("age", new Integer(100));



        //JSONArray list = new JSONArray();
        //list.add(stockData);

        obj.put("companies",stockData);

        try {

            FileWriter file = new FileWriter("C:\\Users\\Public\\Documents\\temp.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


           }


}



