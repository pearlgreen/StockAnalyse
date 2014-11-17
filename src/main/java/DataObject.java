import com.sun.media.sound.InvalidDataException;

import java.util.*;

/**
 * Created by James on 27/10/2014.
 */
public class DataObject {

    private final DataValidator dataValidator;
    String[] validDataSet;

    private String symbol;
    private String company_name;
    private String sector;
    private String isin;
    private String industry;

    private double marketCap;
    private Date creationDate;
    private double roce;
    private double pe_ratio;

    public DataValidator getDataValidator() {
        return dataValidator;
    }

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
    private String results_date;
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

    public String[] getValidDataSet() {
        return validDataSet;
    }

    public String getIsin() {
        return isin;
    }

    public String getIndustry() {
        return industry;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public double getPe_ratio() {
        return pe_ratio;
    }

    public double getShares() {
        return shares;
    }

    public double getDiv_yield() {
        return div_yield;
    }

    public double getDiv_cover() {
        return div_cover;
    }

    public double getOp_margin() {
        return op_margin;
    }

    public double getSpread() {
        return spread;
    }

    public double getPrice_to_cash() {
        return price_to_cash;
    }

    public double getEarning_drops() {
        return earning_drops;
    }

    public double getEarnings_yield() {
        return earnings_yield;
    }

    public double getEarnings_grwth() {
        return earnings_grwth;
    }

    public double getEnterprise_val() {
        return enterprise_val;
    }

    public double getFive_yr_grwth() {
        return five_yr_grwth;
    }

    public double getChange_from_1yr() {
        return change_from_1yr;
    }

    public double getChange_from_low() {
        return change_from_low;
    }

    public double getCurrent_ratio() {
        return current_ratio;
    }

    public double getCredit_short() {
        return credit_short;
    }

    public double getCredit_long() {
        return credit_long;
    }

    public double getCash_equivs() {
        return cash_equivs;
    }

    public double getCurrent_assets() {
        return current_assets;
    }

    public double getRetained_cash() {
        return retained_cash;
    }

    public String getResults_date() {
        return results_date;
    }

    public double getAttributed_profit() {
        return attributed_profit;
    }

    public double getOperations() {
        return operations;
    }

    public double getDebt_to_equity() {
        return debt_to_equity;
    }

    public double getDebtors() {
        return debtors;
    }

    public double getNet_margin() {
        return net_margin;
    }

    public double getNet_debt() {
        return net_debt;
    }

    public double getNet_work_capital() {
        return net_work_capital;
    }

    public double getNet_tang_assets() {
        return net_tang_assets;
    }

    public double getLatest_price() {
        return latest_price;
    }

    public double getPrice_to_sales() {
        return price_to_sales;
    }

    public double getIntangibles() {
        return intangibles;
    }

    public double getPre_tax_profit() {
        return pre_tax_profit;
    }

    public double getTurnover() {
        return turnover;
    }

    private double intangibles;
    private double pre_tax_profit;
    private double turnover;



    public DataObject(String[] inputArray, DataValidator _dataValidator) throws InvalidInputDataException {

        dataValidator = _dataValidator;

        if (!dataValidator.validDatasetSize(inputArray))  throw new InvalidInputDataException("DataObject : Input data array is of incorrect size:" +
                " " + inputArray.length + " and not the required " + dataValidator.getExpectedDatasetSize());

        if (dataValidator.validateFields(inputArray)){

             validDataSet = inputArray ;
             copyToFields();
        }

        else throw new InvalidInputDataException("DataObject : Input data given is invalid  : " + inputArray[0]);

    }

    private void copyToFields() {

        try{

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
        results_date= validDataSet[RSLTPRDDATE];
        isin= validDataSet[ISIN];
        latest_price= Double.parseDouble(validDataSet[LATEST_PRICE]);
        industry=validDataSet[INDUSTRY];
        attributed_profit= Double.parseDouble(validDataSet[ATTRIB_PRFT]);
        }
        catch (NumberFormatException e){

            e.printStackTrace();
        }


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

    private static final int SYMBOL_COLUMN = 1;
    private static final int NAME_COLUMN=2;
    private static final int MARKET_CAP_COLUMN=3;
    private static final int PERATIO_COLUMN=4;
    private static final int SHARES_COLUMN=5;
    private static final int DIVYIELD_COLUMN=6;
    private static final int DIVCOVER_COLUMN=7;
    private static final int OPMARGIN_COLUMN=8;
    private static final int SPREAD=9;
    private static final int PRICETOCASH=10;
    private static final int EARNDROPS=11;
    private static final int EARNSYIELD=12;
    private static final int ENTVALUE=13;
    private static final int FIVEYRGRTH=14;
    private static final int OPERATIONS=15;
    private static final int ROCE=16;
    private static final int DBTEQUITY=17;
    private static final int CURRENT=18;
    private static final int NETMARGIN=19;
    private static final int EARNGWTH=20;
    private static final int DIVGWTH=21;
    private static final int NETDEBT=22;
    private static final int ONEYRCHNG=23;
    private static final int CHNGLOW=24;
    private static final int PRETAXPFT=25;
    private static final int PRCTOSALES=26;
    private static final int RETAINCASH=27;
    private static final int TURNOVER=28;
    private static final int CREDITSHRT=29;
    private static final int CREDITLONG=30;
    private static final int CASHEQUIV=31;
    private static final int INTANGBLES=32;
    private static final int CURRENTASSTS=33;
    private static final int DEBTORS=34;
    private static final int NETWKNGCAPIT=35;
    private static final int NTTANGASSTVL=36;
    private static final int RSLTPRDDATE=37;
    private static final int ISIN=38;
    private static final int LATEST_PRICE=39;
    private static final int INDUSTRY=40;
    private static final int ATTRIB_PRFT=41;

}