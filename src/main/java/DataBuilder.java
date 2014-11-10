import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 02-Nov-2014.
 */
public class DataBuilder {


    List<DataObject> listOfDataObjects = new ArrayList<DataObject>();
    DataValidator dataValidator;


    public DataBuilder(InputHandler input,DataValidator _dataValidator) {

        dataValidator = _dataValidator;
    }

    public DataBuilder(List<String[]> listOfArrays,DataValidator _dataValidator) throws  InvalidInputDataException {

        dataValidator = _dataValidator;

        if (listOfArrays.isEmpty()) throw new InvalidInputDataException("DataBuilder : Input ArrayList is empty");

        for (String[] s : listOfArrays){

            DataObject dataObject;
            try {
             dataObject = new DataObject(s, dataValidator);
                dataObject = new DataObject(s, dataValidator);
                listOfDataObjects.add(dataObject);
            } catch (InvalidInputDataException e) {
              System.out.println("DataBuilder : Problem creating new DataObject");
            }




        }

    }




    public List<DataObject> fetchDataValidDataObjects() {

        return listOfDataObjects;

    }
}
