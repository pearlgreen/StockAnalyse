
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by J on 29-Oct-2014.
 */
public class PersistenceHandler {




    public PersistenceHandler(){


    }


    public String buildFilename(String market){

        String root = "C:\\Users\\Public\\Documents\\";
        String extension = ".json";
        String date = new SimpleDateFormat("ddMMyyyy").format(new Date());;

        return root + market + date + extension;

    }



    public void SaveMarketData(List<Company> companies, String market) {

        FileWriter file = null;
        try {
            file = new FileWriter(buildFilename(market));
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (Company c : companies) {

            Gson gson = new Gson();
            String json = gson.toJson(c);
            //System.out.println(json);
            try { file.write(json);
                } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Company> getMarketData(String market) throws IOException {


        FileReader fileIn = new FileReader(buildFilename(market));

      //  JSONParser parser = new JSONParser();


    //    Object obj = null;
  //      try {
     //       obj = parser.parse(fileIn);
       // } catch (ParseException e) {
       //     e.printStackTrace();
      //  }
     //   JSONObject jsonObject = (JSONObject) obj;

        //DataObject data = new DataObject();
        //data.setCompany_name((String) jsonObject.get(market));

        ArrayList<Company> marketData = new ArrayList<Company>();
        //marketData.add(new Company(data,20140101)) ;

       fileIn.close();

       return null;
  //  }
//
}
}
