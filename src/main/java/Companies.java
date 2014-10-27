import java.util.ArrayList;
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

        Company newCompany = new Company();
        if (!companies.contains(newCompany)) {
            companies.add(newCompany);

            return newCompany;

        }
        return null;
    }
}
