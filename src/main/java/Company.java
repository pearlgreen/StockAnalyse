import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by James on 25/10/2014.
 */
public class Company {

    private String dateOfCreation;
    private String companySymbol;
    private String companyName;
    private String IndustryName;

    public String getIndustryName() {
        return IndustryName;
    }

    public void setIndustryName(String industryName) {
        IndustryName = industryName;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    private String ISIN;

    private List<CompanyData> historicalData;

    public Company() {}

    public Company(DataObject _dataIn, Date dateOfCreation) {

        this.dateOfCreation = new SimpleDateFormat("ddMMyyyy").format(dateOfCreation);
        this.setCompanySymbol(_dataIn.getSymbol());
        this.setCompanyName(_dataIn.getCompany_name());
        this.setIndustryName(_dataIn.getIndustry());
        this.setISIN(_dataIn.getIsin());

        historicalData = new ArrayList<CompanyData>();
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

       public CompanyData getCurrentData() {

        sortDataByLatestFirst(historicalData);
        return historicalData.get(0);

    }


    public List<CompanyData> getHistoricalData() {
        return historicalData;
    }

    public void addData(CompanyData _newData) {

        if (!historicalData.contains(_newData)) historicalData.add(historicalData.size(), _newData);

        else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public CompanyData fetchDataForDate(Date _searchDate) {

        for (CompanyData c : historicalData) {

            if (c.getDateOfData().equals(new SimpleDateFormat("ddMMyyyy").format(_searchDate))) {
                return c;
            }
        }
        return null;

    }


    public void sortDataByLatestFirst(List<CompanyData> historicalData) {

        Collections.sort(historicalData, new Comparator<CompanyData>() {
            @Override
            public int compare(CompanyData o1, CompanyData o2) {
                if (o2.getDateOfData().equals("")) {
                    return -1;
                } else if (o1.getDateOfData().equals("")) {
                    return 1;
                } else {
                    return o1.getDateOfData().compareTo(o2.getDateOfData());
                }

            }
        });


    }
}