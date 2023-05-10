package pro.sky.employeebook.exception;

public class InvalidSurnameException extends RuntimeException {
    public InvalidSurnameException(String surname) {
        super(surname);
    }
}
