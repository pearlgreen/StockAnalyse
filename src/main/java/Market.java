import com.mongodb.Mongo;

import java.io.IOException;
import java.util.*;

/**
 * Created by James on 27/10/2014.
 */
public class Market {

    private ArrayList<Company> companies = new ArrayList<Company>();

    public void Market(){


                 }


    public int buildCompanies (List<DataObject> _DataObjectList) {


        Date _timeOfExtraction = new Date();
        int no_of_Companies_added=0;


        for (DataObject c : _DataObjectList) {

            Company company = this.FindBySymbol(c.getSymbol());

            if (company == null) {

                company = new Company(c, new Date());
                AddCompany(company);
                no_of_Companies_added++;

            }
        }

        sortCompaniesBySymbol();
        return no_of_Companies_added;
    }

    public int buildCompanyData (List<DataObject> _DataObjectList){

        int no_of_dataSetsAddedToCompanies=0;

        for(DataObject o : _DataObjectList){

            Company company = this.FindBySymbol(o.getSymbol());

            if (company != null) {

                CompanyData companyData = company.fetchDataForDate(new Date());

                if (companyData==null) {
                //  System.out.println("companyData"+companyData.getDateOfData());
                    CompanyData newCompanyData = new CompanyData(o,new Date());
                    company.addData(newCompanyData);
                    no_of_dataSetsAddedToCompanies++;
                }
            }
        }

        return no_of_dataSetsAddedToCompanies;
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


    public void setCompanies(ArrayList<Company> _companies){
        companies = _companies;
    }

    public void SetPersistence(MongoPersistenceHandler handlerObject) {

     //   handler = handlerObject;

    }

    public void SaveMarkets(String _marketToSaveAs) {

        MongoPersistenceHandler handler = new MongoPersistenceHandler();
        handler.SaveMarketData(this,_marketToSaveAs);

    }

    public ArrayList<Company> GetListOfCompanies(){

        return companies;
    }


}
