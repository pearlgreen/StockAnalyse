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


    public Company(String _symbol, String _name, String _sector) {

        this.setCompanySymbol(_symbol);
        this.setCompanyName(_name);
        this.setSector(_sector);
        currentData=null;
        historicalData=null;

    }

    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public CompanyData getCurrentData() {
        return currentData;
    }

    public void setCurrentData(CompanyData currentData) {
        this.currentData = currentData;
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
