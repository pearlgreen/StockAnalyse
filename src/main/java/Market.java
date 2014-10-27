import java.util.*;

/**
 * Created by James on 27/10/2014.
 */
public class Market {

    private ArrayList<Company> companies = new ArrayList();

    public void Market(){
                 }


    public int generateFromNewExtraction (List<RawData> _rawDataList) {

        int _timeOfExtraction = new GregorianCalendar().get(Calendar.DATE);
        int count=0;

        for (RawData c : _rawDataList) {

            Company company = this.FindBySymbol(c._symbol);

            if (company == null) {

                company = new Company(c,_timeOfExtraction);
                companies.add(company);
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

        for (Company c : companies) {

            if (symbolToFind.equals(c.getCompanySymbol())) {

                return c;
            }
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



}
