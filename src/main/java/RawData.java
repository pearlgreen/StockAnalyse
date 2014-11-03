import java.util.*;

/**
 * Created by James on 27/10/2014.
 */
public class RawData  {

    private String symbol;
    private String company_name;
    private String sector;
    private double marketCap;
    private int creationDate;
    private double roce;


    public void setSymbol(String _symbol){
        this.symbol = _symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }


    public void RawData(){

    //creationDate = Calendar.getInstance()

}

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getRoce() {
        return roce;
    }
}