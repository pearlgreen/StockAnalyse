import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 25/10/2014.
 */
public class DailyDataSet  {

    private String companySymbol1;
    private String companyName2;
    private String sector3;
    private StockData dailyData;


    public DailyDataSet (){

    }


    public String getCompanySymbol1() {
        return companySymbol1;
    }

    public void setCompanySymbol1(String companySymbol1) {
        this.companySymbol1 = companySymbol1;
    }

    public String getCompanyName2() {
        return companyName2;
    }

    public void setCompanyName2(String companyName2) {
        this.companyName2 = companyName2;
    }

    public String getSector3() {
        return sector3;
    }

    public void setSector3(String sector3) {
        this.sector3 = sector3;
    }

    public List<Float> getStockData() {
        return stockData;
    }

    public void setStockData(List<Float> stockData) {
        this.stockData = stockData;
    }
}
