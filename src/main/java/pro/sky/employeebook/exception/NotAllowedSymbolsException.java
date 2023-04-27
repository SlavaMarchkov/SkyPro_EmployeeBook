package pro.sky.employeebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotAllowedSymbolsException extends RuntimeException {
    public NotAllowedSymbolsException(String message) {
        super(message);
    }
}
