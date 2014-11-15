import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by James on 25/10/2014.
 */
public class Company  {

    private String dateOfCreation;
    private String companySymbol;
    private String companyName;
    private String sector;

    private CompanyData currentData;
    private List<CompanyData> historicalData;


    public Company(DataObject _dataIn, Date dateOfCreation) {

        this.dateOfCreation = new SimpleDateFormat("ddMMyyyy").format(dateOfCreation);
        this.setCompanySymbol(_dataIn.getSymbol());
        this.setCompanyName(_dataIn.getCompany_name());
        this.setSector(_dataIn.getSector());


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


    public CompanyData fetchDataForDate(Date _searchDate){

        for (CompanyData c : historicalData) {
            if (c.getDate().equals(new SimpleDateFormat("ddMMyyyy").format(_searchDate))) {
                return c;
            }
        }

        return null;

    }


}
