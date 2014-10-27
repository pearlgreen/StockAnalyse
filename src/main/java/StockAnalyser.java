

import au.com.bytecode.opencsv.CSVReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;


public class StockAnalyser{

    private List<List> stockData;
    private Companies companies;
    List headers;


    public StockAnalyser() throws SAXException, IOException, URISyntaxException, XPathExpressionException, ParserConfigurationException {

    }

    public List getStockData(){

        return this.stockData;

    }


    public void setStockData(List<List> listInput){

        this.stockData = listInput;
    }


    public void initialise() throws URISyntaxException, IOException {
        //URL url = new URL("http://uk.advfn.com/p.php?pid=filterxdownload&show=1_1_,1_4_,1_2_,1_5_,1_8_,1_11_,1_10_,1_27_,1_89_,2_8_,2_18_,2_14_,2_62_,2_78_,2_79_,3_28_,3_30_,2_27_,2_21_,2_22_,2_45_,2_57_,2_23_,1_12_,1_13_,1_14_,1_87_,1_66_,1_20_,2_9_,2_75_,3_32_&sort=3_32_D&cnstr=&zip=0");
        File file = new File("C:\\Users\\James\\Documents\\GitHub\\XmlGrab\\out\\temp.csv");
        //org.apache.commons.io.FileUtils.copyURLToFile(url, file);
        CSVReader parser = new CSVReader(new FileReader(file));

        stockData = new ArrayList();

        List<String[]> tmp = (ArrayList) parser.readAll();

        for(String[] c : tmp){
            stockData.add((List)Arrays.asList(c));

        }

        headers = (List) stockData.get(0);
        stockData.remove(headers);

    }



    public void generateForDate(Date DateAtTimeOfExtraction){

        for (List c : stockData){
            Company existingCompany;
            existingCompany = companies.FindBySymbol((String) c.get(1));

            if (existingCompany.equals(null)) {
                existingCompany = companies.CreateNewCompany(c);
                            }

            if (existingCompany.fetchDataForDate(DateAtTimeOfExtraction).equals(null)){
                existingCompany.addToHistorical(new CompanyData(c));


            }


        }
    }
    // every list of data
    // if company symbol is new, then create Company
    // if data date for Company is new, add new CompanyData



    public void sortData(final int sortOnColumn) {

        Collections.sort(stockData,new Comparator<List>() {
            @Override
            public int compare(List o1, List o2) {
                if (o1.get(sortOnColumn).equals("") ) {
                    return -1;
                }

                else if (o2.get(sortOnColumn).equals("")) {
                    return 1;
                }
               else {
                        return Float.valueOf((String) o1.get(sortOnColumn)).compareTo(Float.valueOf((String) o2.get(sortOnColumn)));
                    }

              }
        } );

    }


    public List filterOn(int column, float value){


        List toReturn = new ArrayList();

        for(List l : stockData){

            if (Float.class.cast(l.get(column)) > value){
                toReturn.add(l);
            }
        }

        return toReturn;
    }



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

}



