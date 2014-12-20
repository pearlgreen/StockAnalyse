/**
 * Created by J on 20-Dec-2014.
 */
interface PersistenceHandler {

    public void SaveMarketData(Market market, String marketToSaveAs);
    public Market getMarket(String market);
}
