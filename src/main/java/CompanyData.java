import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by James on 25/10/2014.
 */
public class CompanyData {

    private String dateOfData;
    private double LastTradePrice;
    private double MarketCap;
    private double PEratio;
    private double SharesIssue;
    private double DivYield;
    private double DivCover;
    private double Spread;
    private double NoOfEarningsDrops;
    private double EarningsYield;
    private double EnterpriseValue;
    private double FiveYearCompoundGrowth;
    private double Roce;
    private String ResultDate;
    private double NetTangibleAssetsPS;
    private double NetWorkingCapital;
    private double Debtors;
    private double CurrentAssets;
    private double Intangibles;
    private double CashEquiv;
    private double CreditLong;
    private double CreditShort;
    private double Turnover;
    private double Operations;
    private double RetainedCash;
    private double PriceToSales;
    private double OpMargin;
    private double PriceToCashFlow;
    private double DebtToEquity;
    private double CurrentRatio;
    private double NetProfitMargin;
    private double EarningsGrowth;
    private double Change1Yr;
    private double ChangeFromLow;
    private double PreTaxProfitPS;
    private double AttribProfit;


    private CalculatedData calculated;

    public CompanyData() {
    }

    public double getPriceToCashFlow() {
        return PriceToCashFlow;
    }

    public double getAttribProfit() {
        return AttribProfit;
    }

     public double getLastTradePrice() {
        return LastTradePrice;
    }

     public String getResultDate() {
        return ResultDate;
    }

    public double getNetTangibleAssets() {
        return NetTangibleAssetsPS;
    }

    public double getNetWorkingCapital() {
        return NetWorkingCapital;
    }

    public double getDebtors() {
        return Debtors;
    }

    public double getCurrentAssets() {
        return CurrentAssets;
    }

    public double getIntangibles() {
        return Intangibles;
    }

    public double getCashEquiv() {
        return CashEquiv;
    }

    public double getCreditLong() {
        return CreditLong;
    }

    public double getCreditShort() {
        return CreditShort;
    }

    public double getTurnover() {
        return Turnover;
    }

    public double getRetainedCash() {
        return RetainedCash;
    }

    public double getPriceToSales() {
        return PriceToSales;
    }

    public double getOpMargin() {
        return OpMargin;
    }




    public CompanyData(DataObject subSetOfCSVData, Date _dateOfData){

        setDateOfData(_dateOfData);
        calculated = new CalculatedData();
        MarketCap = subSetOfCSVData.getMarketCap();
        PEratio = subSetOfCSVData.getPe_ratio();
        SharesIssue = subSetOfCSVData.getShares();
        DivYield = subSetOfCSVData.getDiv_yield();
        DivCover = subSetOfCSVData.getDiv_cover();
        OpMargin = subSetOfCSVData.getOp_margin();
        Spread = subSetOfCSVData.getSpread();
        PriceToCashFlow = subSetOfCSVData.getPrice_to_cash();
        NoOfEarningsDrops = subSetOfCSVData.getEarning_drops();
        EarningsYield = subSetOfCSVData.getEarnings_yield();
        EnterpriseValue = subSetOfCSVData.getEnterprise_val();
        FiveYearCompoundGrowth = subSetOfCSVData.getFive_yr_grwth();
        Operations = subSetOfCSVData.getOperations();
        Roce = subSetOfCSVData.getRoce();
        DebtToEquity = subSetOfCSVData.getDebt_to_equity();
        CurrentRatio = subSetOfCSVData.getCurrent_ratio();
        NetProfitMargin = subSetOfCSVData.getNet_margin();
        EarningsGrowth = subSetOfCSVData.getEarnings_grwth();
        Change1Yr = subSetOfCSVData.getChange_from_1yr();
        ChangeFromLow = subSetOfCSVData.getChange_from_low();
        PreTaxProfitPS = subSetOfCSVData.getPre_tax_profit();
        PriceToSales = subSetOfCSVData.getPrice_to_sales();
        RetainedCash = subSetOfCSVData.getRetained_cash();
        Turnover = subSetOfCSVData.getTurnover();
        CreditShort = subSetOfCSVData.getCredit_short();
        CreditLong = subSetOfCSVData.getCredit_long();
        CashEquiv = subSetOfCSVData.getCash_equivs();
        Intangibles = subSetOfCSVData.getIntangibles();
        CurrentAssets = subSetOfCSVData.getCurrent_assets();
        Debtors = subSetOfCSVData.getDebtors();
        NetWorkingCapital = subSetOfCSVData.getNet_work_capital();
        NetTangibleAssetsPS = subSetOfCSVData.getNet_tang_assets();
        ResultDate = subSetOfCSVData.getResults_date();
        LastTradePrice = subSetOfCSVData.getLatest_price();
        AttribProfit = subSetOfCSVData.getAttributed_profit();


        this.calculated = calculated;
        //this.setMarketCap(Float.valueOf((String)subSetOfCSVData.get(3)));
    }
        public String getDateOfData() {
            return dateOfData;
        }

        public void setDateOfData(Date dateOfData) {
            this.dateOfData =  new SimpleDateFormat("ddMMyyyy").format(dateOfData) ;
        }

        public double getMarketCap() {
            return MarketCap;
        }

        public void setMarketCap(double marketCap) {
            MarketCap = marketCap;
        }

        public double getPEratio() {
            return PEratio;
        }

        public void setPEratio(double PEratio) {
            this.PEratio = PEratio;
        }

        public double getSharesIssue() {
            return SharesIssue;
        }

        public void setSharesIssue(double sharesIssue) {
            SharesIssue = sharesIssue;
        }

        public double getDivYield() {
            return DivYield;
        }

        public void setDivYield(double divYield) {
            DivYield = divYield;
        }

        public double getDivCover() {
            return DivCover;
        }

        public void setDivCover(double divCover) {
            DivCover = divCover;
        }

        public double getSpread() {
            return Spread;
        }

        public void setSpread(double spread) {
            Spread = spread;
        }

        public double getNoOfEarningsDrops() {
            return NoOfEarningsDrops;
        }

        public void setNoOfEarningsDrops(double noOfEarningsDrops) {
            NoOfEarningsDrops = noOfEarningsDrops;
        }

        public double getEarningsYield() {
            return EarningsYield;
        }

        public void setEarningsYield(double earningsYield) {
            EarningsYield = earningsYield;
        }

        public double getEnterpriseValue() {
            return EnterpriseValue;
        }

        public void setEnterpriseValue(double enterpriseValue) {
            EnterpriseValue = enterpriseValue;
        }

        public double getFiveYearCompoundGrowth() {
            return FiveYearCompoundGrowth;
        }

        public void setFiveYearCompoundGrowth(double fiveYearCompoundGrowth) {
            FiveYearCompoundGrowth = fiveYearCompoundGrowth;
        }

        public double getOperations() {
            return Operations;
        }

        public void setOperations(double operations) {
            Operations = operations;
        }

        public double getRoce() {
            return Roce;
        }

        public void setRoce(double roce) {
            Roce = roce;
        }

        public double getDebtToEquity() {
            return DebtToEquity;
        }

        public void setDebtToEquity(double debtToEquity) {
            DebtToEquity = debtToEquity;
        }

        public double getCurrentRatio() {
            return CurrentRatio;
        }

        public void setCurrentRatio(double currentRatio) {
            CurrentRatio = currentRatio;
        }

        public double getNetProfitMargin() {
            return NetProfitMargin;
        }

        public void setNetProfitMargin(double netProfitMargin) {
            NetProfitMargin = netProfitMargin;
        }

        public double getEarningsGrowth() {
            return EarningsGrowth;
        }

        public void setEarningsGrowth(double earningsGrowth) {
            EarningsGrowth = earningsGrowth;
        }

        public double getChange1Yr() {
            return Change1Yr;
        }

        public void setChange1Yr(double change1Yr) {
            Change1Yr = change1Yr;
        }

        public double getChangeFromLow() {
            return ChangeFromLow;
        }

        public void setChangeFromLow(double changeFromLow) {
            ChangeFromLow = changeFromLow;
        }

        public double getPreTaxProfit() {
            return PreTaxProfitPS;
        }

        public void setPreTaxProfit(double preTaxProfit) {
            PreTaxProfitPS = preTaxProfit;
        }

        public CalculatedData getCalculated() {
            return calculated;
        }

        public void setCalculated(CalculatedData calculated) {
            this.calculated = calculated;
        }



}
