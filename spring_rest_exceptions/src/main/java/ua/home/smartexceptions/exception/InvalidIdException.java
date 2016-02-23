package ua.home.smartexceptions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tsv@ciklum.com
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidIdException extends RuntimeException {

    public InvalidIdException(Long id) {
        super(String.format("Invalid id is %s",String.valueOf(id)));
    }

    public InvalidIdException(Long id, Throwable throwable) {
        super(String.format("Invalid id is %s",String.valueOf(id)), throwable);
    }
}
