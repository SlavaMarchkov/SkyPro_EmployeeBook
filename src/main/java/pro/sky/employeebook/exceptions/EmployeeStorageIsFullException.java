package pro.sky.employeebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        System.out.println("Array Is Full");
    }
}
