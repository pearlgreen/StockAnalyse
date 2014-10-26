import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by James on 25/10/2014.
 */
public class Company  {

    private String companySymbol;
    private String companyName;
    private String sector;
    private CompanyData currentData;
    private List<CompanyData> historicalData;

    public Company (){

    }


    public String getCompanySymbol1() {
        return companySymbol;
    }

    public void setCompanySymbol1(String companySymbol1) {
        this.companySymbol = companySymbol1;
    }

    public String getCompanyName2() {
        return companyName;
    }

    public void setCompanyName2(String companyName2) {
        this.companyName = companyName2;
    }

    public String getSector3() {
        return sector;
    }

    public void setSector3(String sector3) {
        this.sector = sector3;
    }

    public CompanyData getCurrentData() {
        return currentData;
    }

    public void setStockData(CompanyData stockData) {
        this.currentData = stockData;
    }

    public List<CompanyData> getHistoricalData() { return historicalData; }

    public void addToHistorical(CompanyData _newData){

        if (!historicalData.contains(_newData)) historicalData.add(historicalData.size(),_newData);

        else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public CompanyData fetchDataForDate(Date _searchDate){

        for (CompanyData c : historicalData) {
            if (c.getDate().equals(_searchDate)) {
                return c;
            }


        }

        return null;

    }


}
