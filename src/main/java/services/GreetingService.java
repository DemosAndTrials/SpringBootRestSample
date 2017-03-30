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

    public void save(Greeting item) {
        repository.save(item);
    }

    public void save(List<Greeting> model) {
        repository.save(model);
    }

    public Iterable<Greeting> findAll() {
        return repository.findAll();
    }

    public Greeting findById(long id){
        return repository.findOne(id);
    }

    public Iterable<Greeting> findByContentLike(String exp){
        return repository.findByContentContaining(exp);
    }

    public Iterable<Greeting> findByIdGreater(long id){
        return repository.findByIdGreater(id);
    }
}
