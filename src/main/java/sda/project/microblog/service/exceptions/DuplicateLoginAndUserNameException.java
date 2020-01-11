package sda.project.microblog.service.exceptions;

public class DuplicateLoginAndUserNameException extends Exception {
    public DuplicateLoginAndUserNameException(String message){
        super(message);
    }
}
