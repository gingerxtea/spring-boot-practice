package me.yassu.start.start_project.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
