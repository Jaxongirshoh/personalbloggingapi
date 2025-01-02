package dev.wisespirit.personalbloggingapi;

public class PostNotFoundException extends Exception{

    public PostNotFoundException(Throwable cause){
        super(cause);
    }

    public PostNotFoundException(String message){
        super(message);
    }

    public PostNotFoundException(String message,Throwable cause){
        super(message,cause);
    }

}
