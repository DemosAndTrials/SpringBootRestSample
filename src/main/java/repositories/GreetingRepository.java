package repositories;

import models.Greeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    List<Greeting> findByContentContaining(String like);

    @Query(value = "select * from Greeting g where g.id > :id", nativeQuery = true) // custom query
    List<Greeting> findByIdGreater(@Param("id")long id);
}
