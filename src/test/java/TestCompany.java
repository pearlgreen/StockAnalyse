import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

/**
 * Created by J on 16-Nov-2014.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestCompany {


    DataObject mockedData = mock(DataObject.class);


    @Before
    public void setUp(){

        stub(mockedData.getSymbol()).toReturn("TSCO");
        stub(mockedData.getCompany_name()).toReturn("Tesco");
        stub(mockedData.getIndustry()).toReturn("XXX");
        stub(mockedData.getIsin()).toReturn("XXX");

    }

    @Test
    public void Company_returns_nullObjectWhenNoDataFoundForDate(){

        Company company = new Company(mockedData, new Date());

        Date date = new Date(114,01,02);
        Date dateForNull = new Date(114,01,03);

        CompanyData companyData1 = new CompanyData(mockedData,date);
        company.addData(companyData1);

        Assert.assertNull(company.fetchDataForDate(dateForNull));

    //   Assert.assertNull(companyData);


    }


    @Test
    public void Company_returns_sorted_currentData(){



        Company company = new Company(mockedData, new Date());


        Date dateOldest = new Date(114,01,01);
        Date dateOld = new Date(114,01,02);
        Date dateLater = new Date(114,01,03);
        Date dateLatest = new Date(114,01,04);


        CompanyData companyData1 = new CompanyData(mockedData,dateOld);
        CompanyData companyData2 = new CompanyData(mockedData,dateLatest);
        CompanyData companyData3 = new CompanyData(mockedData,dateOldest);

        company.addData(companyData1);
        company.addData(companyData2);
        company.addData(companyData3);

        Assert.assertEquals(company.getCurrentData(), companyData2);

        CompanyData companyData4 = new CompanyData(mockedData,dateLater);
        company.addData(companyData4);

        Assert.assertEquals(company.getCurrentData(), companyData2);


    }


}
