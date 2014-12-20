import com.google.gson.Gson;
import com.google.gson.JsonParser;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import java.net.UnknownHostException;

/**
 * Created by J on 20-Dec-2014.
 */
public class MongoPersistenceHandler implements PersistenceHandler {

    MongoClient mongo;
    DB database;

    public MongoPersistenceHandler() {

        System.out.println("MongoPersistenceHandler : Using Mongo DB, attempting to connect..");

        try {
            mongo = new MongoClient( "localhost" );
            System.out.println("MongoPersistenceHandler : Connected ");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        database = mongo.getDB("StockAnalyserDB");

        if (database!=null) System.out.println("MongoPersistenceHandler : Database Found ");


      //  database.getName();

    }


        public void SaveMarketData(Market marketDate, String market) {

            System.out.println("MongoPersistence : Save Market Data");
            // for (Company c : companies) {

            Gson gson = new Gson();

            String json = gson.toJson(marketDate);

            DBObject dbObject = (DBObject) JSON.parse(json);

            database.getCollection(market).drop();
            DBCollection collection = database.createCollection(market,null);

            collection.insert(dbObject);
            System.out.println("MongoPersistence : Added " + market + " as " + collection.count() + " DB Collection");

            mongo.close();

        }

    @Override
    public Market getMarket(String market) {

        System.out.println("MongoPersistenceHandler : Attempting to load " + market + " from DB Collection" );

        DBCollection collection = database.getCollection(market);
        String json = JSON.serialize(collection.findOne());

        Gson gson = new Gson();

        JsonParser parser = new JsonParser();
        mongo.close();

        Market marketLoaded = gson.fromJson(json, Market.class);

        System.out.println("MongoPersistenceHandler : Market Loaded" );
        return marketLoaded;



    }


}

