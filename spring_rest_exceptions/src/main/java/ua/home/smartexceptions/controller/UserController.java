package ua.home.smartexceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.home.smartexceptions.exception.InternalServerException;
import ua.home.smartexceptions.exception.InvalidIdException;

/**
 * @author tsv@ciklum.com
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getUser(@PathVariable("id") Long id) {
        if (id == 2) throw new InternalServerException("Unexpected exception");

        if (id == 3) throw new InvalidIdException(id);

        return String.format("Id from request is %s", String.valueOf(id));
    }
}
