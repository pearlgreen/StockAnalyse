import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 02-Nov-2014.
 */
public class DataBuilder {


    List<DataObject> listOfDataObjects = new ArrayList<DataObject>();


    public DataBuilder(InputHandler input) {

    }

    public DataBuilder(List<String[]> listOfArrays) throws  InvalidInputDataException {

        if (listOfArrays.isEmpty()) throw new InvalidInputDataException("DataBuilder : Input ArrayList is empty");

        for (String[] s : listOfArrays){

            DataObject dataObject;
            try {
             dataObject = new DataObject(s);
                dataObject = new DataObject(s);
                listOfDataObjects.add(dataObject);
            } catch (InvalidInputDataException e) {
              System.out.println("DataBuilder : Problem creating new DataObject");
            }




        }

    }




    public List<DataObject> fetchDataValidDataObject() {

        return listOfDataObjects;

    }
}
