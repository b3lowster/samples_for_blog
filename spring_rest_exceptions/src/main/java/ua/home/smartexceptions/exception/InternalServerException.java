package ua.home.smartexceptions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tsv@ciklum.com
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

    public InternalServerException(String s) {
        super(String.format("Exception while precessing server operation [%s]",s));
    }

    public InternalServerException(String s, Throwable throwable) {
        super(String.format("Exception while precessing server operation [%s]",s), throwable);
    }
}
