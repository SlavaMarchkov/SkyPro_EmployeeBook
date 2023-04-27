package pro.sky.employeebook.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

}
