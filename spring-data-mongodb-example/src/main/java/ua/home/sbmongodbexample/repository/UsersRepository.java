package ua.home.sbmongodbexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.home.sbmongodbexample.pojo.User;

/**
 * @author tsv@ciklum.com
 */
public interface UsersRepository extends MongoRepository<User, String> {
}
