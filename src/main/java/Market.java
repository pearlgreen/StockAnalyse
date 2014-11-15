import java.io.IOException;
import java.util.*;

/**
 * Created by James on 27/10/2014.
 */
public class Market {

    private ArrayList<Company> companies = new ArrayList<Company>();

    PersistenceHandler handler;

    public void Market(){


                 }


    public int buildCompanies (List<DataObject> _DataObjectList) {


        Date _timeOfExtraction = new Date();
        int count=0;


        for (DataObject c : _DataObjectList) {

            Company company = this.FindBySymbol(c.getSymbol());

            if (company == null) {

                company = new Company(c,new Date());
                AddCompany(company);
                count++;

                }

            CompanyData companyData = company.fetchDataForDate(_timeOfExtraction);

            if (companyData == null) {
                company.addData(companyData);
            }
        }

        return count;
    }


    public Company FindBySymbol(String symbolToFind) {


        if (companies.size()!=0) {
            for (Company c : companies) {

                if (symbolToFind.equals(c.getCompanySymbol())) {

                    return c;
                }
            }
            return null;
        }

        return null;
    }

    public void sortCompaniesBySymbol() {

        Collections.sort(companies, new Comparator<Company>() {
            @Override
            public int compare(Company o1, Company o2) {
                if (o1.getCompanySymbol().equals("")) {
                    return -1;
                } else if (o2.getCompanySymbol().equals("")) {
                    return 1;
                } else {
                    return o1.getCompanySymbol().compareTo(o2.getCompanySymbol());
                }

            }
        });

    }

    public void AddCompany(Company company) {

        if (FindBySymbol(company.getCompanySymbol())==null){
           companies.add(company);
        }
            }
    
    public int getNoOfCompanies(){
        return companies.size();
     }


    public void SetPersistence(PersistenceHandler handlerObject) {

        handler = handlerObject;

    }

    public void SaveMarkets(String _marketToSaveAs) {

        handler.SaveMarketData(companies,_marketToSaveAs);

    }

    public void LoadCompanies(String _marketToLookFor) {

        try {
            System.out.println(handler.buildFilename(_marketToLookFor));

            companies = handler.getMarketData(_marketToLookFor);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
