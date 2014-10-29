import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 29-Oct-2014.
 */
public class PersistenceHandler {


    String filename = "C:\\Users\\Public\\Documents\\temp.json";

    public PersistenceHandler (){


    }



    public void SaveMarketData(ArrayList<Company> companies, String market) {

        FileWriter file = null;
        try {
            file = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }


        JSONObject obj = new JSONObject();

        for (Company c : companies) {
            String jsonText = JSONValue.toJSONString(c);
            obj.put(market, jsonText);
        }
        try {

            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Company> getMarketData(String market) throws IOException {


        FileReader fileIn = new FileReader(filename);

        JSONParser parser = new JSONParser();


        Object obj = null;
        try {
            obj = parser.parse(fileIn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;

        RawData data = new RawData();
        data._companyName = (String) jsonObject.get(market);

        ArrayList<Company> marketData = new ArrayList<Company>();
        marketData.add(new Company(data,20140101)) ;

        System.out.println(marketData.size());

        fileIn.close();

        return marketData;
    }
}
