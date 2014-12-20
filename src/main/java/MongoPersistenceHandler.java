import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.UnknownHostException;

/**
 * Created by J on 20-Dec-2014.
 */
public class MongoPersistenceHandler {

    MongoClient mongo;
    DB database;

    public MongoPersistenceHandler() {
        try {
            mongo = new MongoClient( "localhost" );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        database = mongo.getDB("StockAnalyserDB");
      //  database.getName();

    }


        public void SaveMarketData(Market marketDate, String market) {


            // for (Company c : companies) {

            Gson gson = new Gson();
            String json = gson.toJson(marketDate);

            DBObject dbObject = (DBObject) JSON.parse(json);

            database.getCollection(market).drop();
            DBCollection collection = database.createCollection(market,null);

            collection.insert(dbObject);
            System.out.println(collection.count());

            mongo.close();




        }


    }

