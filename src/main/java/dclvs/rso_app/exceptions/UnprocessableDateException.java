package dclvs.rso_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableDateException extends RuntimeException {

    public UnprocessableDateException(String message) {
        super(message);
    }

}
