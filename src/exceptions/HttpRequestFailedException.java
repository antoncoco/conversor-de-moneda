package exceptions;

public class HttpRequestFailedException extends Exception{
    private final String message;
    public HttpRequestFailedException(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
