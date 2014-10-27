import java.util.Date;
import java.util.List;

/**
 * Created by James on 25/10/2014.
 */
public class CompanyData {

    private int dateOfData;
    private double MarketCap;
    private float PEratio;
    private float SharesIssue;
    private float DivYield;
    private float DivCover;
    private float Spread;
    private float NoOfEarningsDrops;
    private float EarningsYield;
    private float EnterpriseValue;
    private float FiveYearCompoundGrowth;
    private float Operations;
    private float Roce;
    private float DebtToEquity;
    private float CurrentRatio;
    private float NetProfitMargin;
    private float EarningsGrowth;
    private float Change1Yr;
    private float ChangeFromLow;
    private float PreTaxProfit;

    private CalculatedData calculated;


    public CompanyData(RawData subSetOfCSVData, int _dateOfData){

        dateOfData = _dateOfData;
        calculated = new CalculatedData();
        this.setMarketCap(subSetOfCSVData._marketCap);
        //this.setMarketCap(Float.valueOf((String)subSetOfCSVData.get(3)));


    }

    public int getDate() {
        return dateOfData;
    }

    public float getPEratio() {
        return PEratio;
    }

    public void setPEratio(float PEratio) {
        this.PEratio = PEratio;
    }

    public float getSharesIssue() {
        return SharesIssue;
    }

    public void setSharesIssue(float sharesIssue) {
        SharesIssue = sharesIssue;
    }

    public float getDivYield() {
        return DivYield;
    }

    public void setDivYield(float divYield) {
        DivYield = divYield;
    }

    public float getDivCover() {
        return DivCover;
    }

    public void setDivCover(float divCover) {
        DivCover = divCover;
    }

    public float getSpread() {
        return Spread;
    }

    public void setSpread(float spread) {
        Spread = spread;
    }

    public float getNoOfEarningsDrops() {
        return NoOfEarningsDrops;
    }

    public void setNoOfEarningsDrops(float noOfEarningsDrops) {
        NoOfEarningsDrops = noOfEarningsDrops;
    }

    public float getEarningsYield() {
        return EarningsYield;
    }

    public void setEarningsYield(float earningsYield) {
        EarningsYield = earningsYield;
    }

    public float getEnterpriseValue() {
        return EnterpriseValue;
    }

    public void setEnterpriseValue(float enterpriseValue) {
        EnterpriseValue = enterpriseValue;
    }

    public float getFiveYearCompoundGrowth() {
        return FiveYearCompoundGrowth;
    }

    public void setFiveYearCompoundGrowth(float fiveYearCompoundGrowth) {
        FiveYearCompoundGrowth = fiveYearCompoundGrowth;
    }

    public float getOperations() {
        return Operations;
    }

    public void setOperations(float operations) {
        Operations = operations;
    }

    public float getROCE() {
        return Roce;
    }

    public void setROCE(float ROCE) {
        this.Roce = ROCE;
    }

    public float getDebtToEquity() {
        return DebtToEquity;
    }

    public void setDebtToEquity(float debtToEquity) {
        DebtToEquity = debtToEquity;
    }

    public float getCurrentRatio() {
        return CurrentRatio;
    }

    public void setCurrentRatio(float currentRatio) {
        CurrentRatio = currentRatio;
    }

    public float getNetProfitMargin() {
        return NetProfitMargin;
    }

    public void setNetProfitMargin(float netProfitMargin) {
        NetProfitMargin = netProfitMargin;
    }

    public float getEarningsGrowth() {
        return EarningsGrowth;
    }

    public void setEarningsGrowth(float earningsGrowth) {
        EarningsGrowth = earningsGrowth;
    }

    public float getChange1Yr() {
        return Change1Yr;
    }

    public void setChange1Yr(float change1Yr) {
        Change1Yr = change1Yr;
    }

    public float getChangeFromLow() {
        return ChangeFromLow;
    }

    public void setChangeFromLow(float changeFromLow) {
        ChangeFromLow = changeFromLow;
    }

    public float getPreTaxProfit() {
        return PreTaxProfit;
    }

    public void setPreTaxProfit(float preTaxProfit) {
        PreTaxProfit = preTaxProfit;
    }

    public double getMarketCap() {
        return
                MarketCap;
    }

    public void setMarketCap(double marketCap) {
        MarketCap = marketCap;
    }
}
