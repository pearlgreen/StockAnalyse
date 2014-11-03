import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 02-Nov-2014.
 */
public class DataBuilder {

   final int DATASET_SIZE = 41;

   private static final int SYMBOL_COLUMN = 1;
    List<RawData> listOfDataObjects = new ArrayList<RawData>();


    public DataBuilder(String[] array) throws  InvalidInputDataException{

        if (array.length != DATASET_SIZE){

            throw new InvalidInputDataException("Input data array is of size: " + array.length + " and not the required " + DATASET_SIZE);

        }
    }

    public DataBuilder(InputHandler input) {


    }

    public DataBuilder(List<String[]> listOfArrays) throws  InvalidInputDataException {

        if (listOfArrays.isEmpty()) throw new InvalidInputDataException("Input ArrayList is empty");

        for (String[] s : listOfArrays){

            if (s.length != DATASET_SIZE){

                throw new InvalidInputDataException("Input data array is of size: " + s.length + " and not the required " + DATASET_SIZE);
            }


            if(s[SYMBOL_COLUMN-1].isEmpty()); throw new InvalidInputDataException("Array SYMBOL_COLUMN is empty");



           // RawData rawData = new RawData();

           // listOfDataObjects.add(rawData);
        }

        }




    public List<RawData> fetchDataValidDataObject() {

        return listOfDataObjects;

    }
}
