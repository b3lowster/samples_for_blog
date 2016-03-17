package ua.home.sbmongodbexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.home.sbmongodbexample.pojo.User;
import ua.home.sbmongodbexample.service.UsersService;

import java.util.List;

/**
 * @author tsv@ciklum.com
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAllUsers(Pageable p) {
        return usersService.getUsers(p);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    public void saveOutlet(@RequestBody User user) {
        usersService.saveUser(user);
    }
}
