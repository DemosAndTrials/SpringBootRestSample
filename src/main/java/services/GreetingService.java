package services;

import models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.GreetingRepository;
import java.util.List;

@Service
public class GreetingService {

    @Autowired
    GreetingRepository repository;

    public void create(Greeting item) {
        repository.save(item);
    }

    public void create(List<Greeting> model) {
        repository.save(model);
    }

    public void update(Greeting item) {
        repository.save(item);
    }

    public Iterable<Greeting> findAll() {
        return repository.findAll();
    }

    public Greeting findById(long id){
        return repository.findOne(id);
    }

    public Iterable<Greeting> findByContentLike(String exp){
        return repository.findByContentContainingIgnoreCase(exp);
    }

    public Iterable<Greeting> findByIdGreater(long id){
        return repository.findByIdGreater(id);
    }
}
