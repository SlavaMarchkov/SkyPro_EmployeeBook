package pro.sky.employeebook.exception;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String name) {
        super(name);
    }
}
