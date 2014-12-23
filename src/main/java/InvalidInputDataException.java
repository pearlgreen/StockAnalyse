/**
 * Created by J on 02-Nov-2014.
 */
public class InvalidInputDataException extends Throwable {
    private String message="";

    public InvalidInputDataException(int length) {


    }

    public InvalidInputDataException(String s) {

        this.message = s;
       // System.out.println(this.message);

    }

    public String getErrorMessage(){

        return message;
    }
}
