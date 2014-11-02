import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 02-Nov-2014.
 */
public class DataBuilder {

   final int DATASET_SIZE = 31;

   private static final int SYMBOL_COLUMN = 1;


    private String symbol;


    public DataBuilder(String[] array) throws  InvalidInputDataException{

        if (array.length != DATASET_SIZE){

            throw new InvalidInputDataException(array.length);

        }


    }

    public DataBuilder(InputHandler input) {


    }

    public DataBuilder(List<String[]> listOfArrays) throws  InvalidInputDataException {

        if (listOfArrays.isEmpty()) throw new InvalidInputDataException("Input ArrayList is empty");

        for (String[] s : listOfArrays){

            if (s.length != DATASET_SIZE){

                throw new InvalidInputDataException(s.length);
            }

            RawData rawData = new RawData();

            if(!s[SYMBOL_COLUMN].isEmpty()) setSymbol(s[SYMBOL_COLUMN]);
            else throw new InvalidInputDataException("Array SYMBOL_COLUMN is empty");
        }

    }

    public ArrayList<RawData> fetchData() {

       ArrayList<RawData> list = new ArrayList<RawData>();

    return list;
    }

    public void setSymbol(String _symbol) {

        this.symbol = _symbol;
    }
}
