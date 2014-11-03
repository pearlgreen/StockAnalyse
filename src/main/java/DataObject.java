import java.util.*;

/**
 * Created by James on 27/10/2014.
 */
public class DataObject {

    private String symbol;
    private String company_name;
    private String sector;
    private double marketCap;
    private int creationDate;
    private double roce;

   final int DATASET_SIZE = 41;

    public DataObject(String[] inputArray) throws InvalidInputDataException {


        if (inputArray.length != DATASET_SIZE)  throw new InvalidInputDataException("Input data array is of size: " + inputArray.length + " and not the required " + DATASET_SIZE);

        if (inputArray[SYMBOL_COLUMN].isEmpty())   throw new InvalidInputDataException("Input data is invalid/empty at SYMBOL_COLUMN");

          
    }



    public String getSymbol() {
        return symbol;
    }
    public String getCompany_name() {
        return company_name;
    }
    public double getMarketCap() {
        return marketCap;
    }
    public String getSector() {
        return sector;
    }
    public double getRoce() {
        return roce;
    }

    private static final int SYMBOL_COLUMN = 0;
    private static final int NAME_COLUMN=1;
    private static final int MARKET_CAP_COLUMN=2;
    private static final int PERATIO_COLUMN=3;
    private static final int SHARES_COLUMN=4;
    private static final int DIVYIELD_COLUMN=5;
    private static final int DIVCOVER_COLUMN=6;
    private static final int OPMARGIN_COLUMN=7;
    private static final int SPREAD=8;
    private static final int PRICETOCASH=9;
    private static final int EARNDROPS10=10;
    private static final int EARNSYIELD=11;
    private static final int ENTVALUE=12;
    private static final int FIVEYRGRTH=13;
    private static final int OPERATIONS=14;
    private static final int ROCE=15;
    private static final int DBTEQUITY=16;
    private static final int CURRENT=17;
    private static final int NETMARGIN=18;
    private static final int EARNGWTH=19;
    private static final int DIVGWTH=20;
    private static final int NETDEBT=21;
    private static final int ONEYRCHNG=22;
    private static final int CHNGLOW=23;
    private static final int PRETAXPFT=24;
    private static final int PRCTOSALES=25;
    private static final int RETAINCASH=26;
    private static final int TURNOVER=27;
    private static final int CREDITSHRT=28;
    private static final int CREDITLONG=29;
    private static final int CASHEQUIV=30;
    private static final int INTANGBLES=31;
    private static final int CURRENTASSTS=32;
    private static final int DEBTORS=33;
    private static final int NETWKNGCAPIT=34;
    private static final int NTTANGASSTVL=35;
    private static final int RSLTPRDDATE=36;
    private static final int ISIN=37;
    private static final int LATEST_PRICE=38;
    private static final int INDUSTRY=39;
    private static final int ATTRIB_PRFT=40;

}