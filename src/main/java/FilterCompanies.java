import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by J on 01-Feb-2015.
 */
public class FilterCompanies {

    List<Company> collectionOfCompany;
    List<Company> filteredCompanyList;

    public FilterCompanies(){

    }

    public FilterCompanies(List<Company> _collectionOfCompany){

        collectionOfCompany = _collectionOfCompany;

    }


    public List<Company> getFilteredList(){

        return filteredCompanyList;


    }


    public void applyFilter(){

       filteredCompanyList = collectionOfCompany.stream()
               .filter(p -> p.getCurrentData().getCurrentRatio() < 2.5)
               .filter(p -> p.getCurrentData().getFiveYearCompoundGrowth() > 5)
               .filter(p -> p.getCurrentData().getEarningsGrowth() > 0)
               .filter(p -> p.getCurrentData().getMarketCap() < 5000)
               .filter(p -> p.getCurrentData().getRoce() > 0)
               .filter(p -> p.getCurrentData().getNetProfitMargin() > 5)
               .filter(p -> p.getCurrentData().getCalculatedReturnOnCapital() > 2)
               .filter(p -> p.getCurrentData().getEarningsYield() > 6)
                        .collect(Collectors.toList());


    }


  //  Accepts Collection of Companies
    //        Applies Filter
      //              Returns Filtered Collection

}
