package repositories;

import models.Greeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

/*
     Greeting repository
     http://docs.spring.io/spring-data/jpa/docs/1.5.1.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 */
public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    // WHERE UPPER(Content) LIKE UPPER(%like%)
    List<Greeting> findByContentContainingIgnoreCase(String like);

    // custom query
    @Query(value = "select * from Greeting g where g.id > :id", nativeQuery = true)
    List<Greeting> findByIdGreater(@Param("id")long id);
}
