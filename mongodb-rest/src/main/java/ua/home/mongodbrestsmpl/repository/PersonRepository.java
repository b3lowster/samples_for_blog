package ua.home.mongodbrestsmpl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.home.mongodbrestsmpl.pojo.Person;

import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findByLastName(@Param("name") String name);
}
