
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by J on 29-Oct-2014.
 */
public class PersistenceHandler {


    public String buildFilename(String market){

        String root = "C:\\Users\\Public\\Documents\\";
        String extension = ".json";
     //   String date = new SimpleDateFormat("ddMMyyyy").format(new Date());;

        return root + market + extension;

    }



    public void SaveMarketData(Market marketDate, String market) {

        FileWriter file = null;
        try {
            file = new FileWriter(buildFilename(market));
        } catch (IOException e) {
            e.printStackTrace();
        }



       // for (Company c : companies) {

            Gson gson = new Gson();
            String json = gson.toJson(marketDate);
            //System.out.println(json);
            try { file.write(json);
                } catch (IOException e) {
                e.printStackTrace();
            }


        try {
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Market getMarket(String market) throws IOException {


       File filein = new File(buildFilename(market));
      //  JSONParser parser = new JSONParser();

        StringReader json = new StringReader(FileUtils.readFileToString(filein));

        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(json);
        jsonReader.setLenient(true);

        JsonParser parser = new JsonParser();



        JsonObject jArray = parser.parse(jsonReader).getAsJsonObject();

               //for(JsonElement obj : jArray )
       // {
            Market marketLoaded = gson.fromJson( jArray , Market.class);

        //}

        //ArrayList<Company> marketData = new ArrayList<Company>();
        //marketData.add(new Company(data,20140101)) ;

        System.out.println(marketLoaded.getNoOfCompanies());
        System.out.println(marketLoaded.FindBySymbol("TSCO").getCurrentData().getDebtToEquity());



       return marketLoaded;
  //  }
//
}
}
