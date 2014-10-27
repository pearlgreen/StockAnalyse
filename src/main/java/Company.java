import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by James on 25/10/2014.
 */
public class Company  {

    private int dateOfCreation;
    private String companySymbol;
    private String companyName;
    private String sector;

    private CompanyData currentData;
    private List<CompanyData> historicalData;


    public Company(RawData _dataIn, int dateOfCreation) {

        this.dateOfCreation = dateOfCreation;
        this.setCompanySymbol(_dataIn._symbol);
        this.setCompanyName(_dataIn._companyName);
        this.setSector(_dataIn._sector);

        currentData = new CompanyData(_dataIn, dateOfCreation);
        historicalData = new ArrayList<CompanyData>();
        historicalData.add(currentData);

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

    public void addData(CompanyData _newData){

        if (!historicalData.contains(_newData)) historicalData.add(historicalData.size(),_newData);

        else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public CompanyData fetchDataForDate(int _searchDate){

        for (CompanyData c : historicalData) {
            if (c.getDate()==(_searchDate)) {
                return c;
            }
        }

        return null;

    }


}
