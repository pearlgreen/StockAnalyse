import com.sun.media.sound.InvalidDataException;

import java.util.*;

/**
 * Created by James on 27/10/2014.
 */
public class DataObject {

    final int DATASET_SIZE = 41;
    private final DataValidator dataValidator;
    String[] validDataSet;

    private String symbol;
    private String company_name;
    private String sector;
    private String isin;
    private String industry;

    private double marketCap;
    private int creationDate;
    private double roce;
    private double pe_ratio;
    private double shares;
    private double div_yield;
    private double div_cover;
    private double op_margin;
    private double spread;
    private double price_to_cash;
    private double earning_drops;
    private double earnings_yield;
    private double earnings_grwth;
    private double enterprise_val;
    private double five_yr_grwth;
    private double change_from_1yr;
    private double change_from_low;
    private double current_ratio;
    private double credit_short;
    private double credit_long;
    private double cash_equivs;
    private double current_assets;
    private double retained_cash;
    private double results_date;
    private double attributed_profit;
    private double operations;
    private double debt_to_equity;
    private double debtors;
    private double net_margin;
    private double net_debt;
    private double net_work_capital;
    private double net_tang_assets;
    private double latest_price;
    private double price_to_sales;
    private double intangibles;
    private double pre_tax_profit;
    private double turnover;



    public DataObject(String[] inputArray, DataValidator _dataValidator) throws InvalidInputDataException {

        dataValidator = _dataValidator;


        if (!dataValidator.validDatasetSize(inputArray))  throw new InvalidInputDataException("Input data array is of incorrect size:" +
                " " + inputArray.length + " and not the required " + dataValidator.getExpectedDatasetSize());

        List errors = validateDataFields(inputArray);


        if (errors.isEmpty()){

            validDataSet = inputArray ;
            copyToFields();
        }

        else throw new InvalidInputDataException("DataObject : Input data at column(s) " + errors.size() + " are incorrect");

    }

    private void copyToFields() {

        symbol = validDataSet[SYMBOL_COLUMN];
        roce = Double.parseDouble(validDataSet[ROCE]);
        company_name = validDataSet[NAME_COLUMN];
        marketCap = Double.parseDouble(validDataSet[MARKET_CAP_COLUMN]);
        pe_ratio = Double.parseDouble(validDataSet[PERATIO_COLUMN]);
        shares = Double.parseDouble(validDataSet[SHARES_COLUMN]);
        div_yield = Double.parseDouble(validDataSet[DIVYIELD_COLUMN]);
        div_cover= Double.parseDouble(validDataSet[DIVCOVER_COLUMN]);
        op_margin = Double.parseDouble(validDataSet[OPMARGIN_COLUMN]);
        spread = Double.parseDouble(validDataSet[SPREAD]);
        price_to_cash= Double.parseDouble(validDataSet[PRICETOCASH]);
        earning_drops= Double.parseDouble(validDataSet[EARNDROPS]);
        earnings_yield= Double.parseDouble(validDataSet[EARNSYIELD]);
        enterprise_val= Double.parseDouble(validDataSet[ENTVALUE]);
        five_yr_grwth= Double.parseDouble(validDataSet[FIVEYRGRTH]);
        operations= Double.parseDouble(validDataSet[OPERATIONS]);
        debt_to_equity= Double.parseDouble(validDataSet[DBTEQUITY]);
        current_ratio= Double.parseDouble(validDataSet[CURRENT]);
        net_margin = Double.parseDouble(validDataSet[NETMARGIN]);
        earnings_grwth= Double.parseDouble(validDataSet[EARNGWTH]);
        net_debt= Double.parseDouble(validDataSet[NETDEBT]);
        change_from_1yr= Double.parseDouble(validDataSet[ONEYRCHNG]);
        change_from_low= Double.parseDouble(validDataSet[CHNGLOW]);
        pre_tax_profit= Double.parseDouble(validDataSet[PRETAXPFT]);
        price_to_sales= Double.parseDouble(validDataSet[PRCTOSALES]);
        retained_cash= Double.parseDouble(validDataSet[RETAINCASH]);
        turnover= Double.parseDouble(validDataSet[TURNOVER]);
        credit_short= Double.parseDouble(validDataSet[CREDITSHRT]);
        credit_long= Double.parseDouble(validDataSet[CREDITLONG]);
        cash_equivs= Double.parseDouble(validDataSet[CASHEQUIV]);
        intangibles= Double.parseDouble(validDataSet[INTANGBLES]);
        current_assets= Double.parseDouble(validDataSet[CURRENTASSTS]);
        debtors= Double.parseDouble(validDataSet[DEBTORS]);
        net_work_capital= Double.parseDouble(validDataSet[NETWKNGCAPIT]);
        net_tang_assets= Double.parseDouble(validDataSet[NTTANGASSTVL]);
        results_date= Double.parseDouble(validDataSet[RSLTPRDDATE]);
        isin= validDataSet[ISIN];
        latest_price= Double.parseDouble(validDataSet[LATEST_PRICE]);
        industry=validDataSet[INDUSTRY];
        attributed_profit= Double.parseDouble(validDataSet[ATTRIB_PRFT]);



    }





    private List<String> validateDataFields(String[] inputArray) {

        List<String> errors = new ArrayList<String>();

        if (inputArray[SYMBOL_COLUMN].isEmpty())  errors.add("Empty data at:" +SYMBOL_COLUMN);
        if (inputArray[NAME_COLUMN].isEmpty()) errors.add("Empty data at:" +NAME_COLUMN);
        if (inputArray[MARKET_CAP_COLUMN].isEmpty()) errors.add("Empty data at:" +MARKET_CAP_COLUMN);
        if (inputArray[SHARES_COLUMN].isEmpty()) errors.add("Empty data at:" +SHARES_COLUMN);

        return errors;
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
    private static final int EARNDROPS=10;
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