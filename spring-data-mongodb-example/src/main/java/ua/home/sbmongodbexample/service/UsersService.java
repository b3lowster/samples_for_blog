package ua.home.sbmongodbexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.home.sbmongodbexample.pojo.User;
import ua.home.sbmongodbexample.repository.UsersRepository;

import java.util.List;

/**
 * @author tsv@ciklum.com
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> getUsers(Pageable p){

        return usersRepository.findAll(p).getContent();
    }

    public void saveUser(User user) {
        usersRepository.save(user);
    }
}
