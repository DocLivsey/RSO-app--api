package dclvs.rso_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEmailException extends RuntimeException {

    public UnprocessableEmailException(String message) {
        super(message);
    }

}
