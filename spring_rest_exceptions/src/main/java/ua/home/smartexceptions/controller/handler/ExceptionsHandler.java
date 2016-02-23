package ua.home.smartexceptions.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.home.smartexceptions.exception.ErrorResponse;
import ua.home.smartexceptions.exception.InternalServerException;
import ua.home.smartexceptions.exception.InvalidIdException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tsv@ciklum.com
 */
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleError(InternalServerException ex) {
        return new ErrorResponse(500, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIdException.class)
    public void handleError(HttpServletRequest req, InvalidIdException exception, HttpServletResponse response) throws IOException {
        writeResponse(req,response,exception);
    }

    private void writeResponse(HttpServletRequest req, HttpServletResponse response, Exception e) throws IOException {
        response.getWriter().append(e.getMessage());
    }
}
