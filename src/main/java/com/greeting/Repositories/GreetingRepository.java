package com.greeting.Repositories;

import com.greeting.Entities.Greeting;
import org.springframework.data.repository.CrudRepository;


public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}
