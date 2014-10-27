import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by James on 27/10/2014.
 */
public class Companies {

    private ArrayList<Company> companies;

    public Company FindBySymbol(String symbolToFind) {

        Company foundCompany;

        for (Company c : companies) {
            if (symbolToFind.equals(c.getCompanySymbol())) ;
            return c;
        }


        return null;

    }

    public Company CreateNewCompany(List c) {

        Company newCompany = new Company(c);
        if (this.FindBySymbol(newCompany.getCompanySymbol()).equals(null)
                && newCompany.getCurrentData().getMarketCap()!=0) {
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

}
