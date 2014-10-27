import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by James on 27/10/2014.
 */
public class Companies {

    private ArrayList<Company> companies = new ArrayList();

    public Company FindBySymbol(String symbolToFind) {

           for (Company c : companies) {
                if (symbolToFind.equals(c.getCompanySymbol())) ;
                return c;
            }

            return null;


    }

    public Company CreateNewCompany(RawData c) {

        Company newCompany = new Company(c.parseSymbol(),c.parseName(),c.parseSector());
        if (this.FindBySymbol(c.parseSymbol()).equals(null)
                && (c.parseMarketCap() != 0)) {
            companies.add(newCompany);
            return newCompany;

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
}
