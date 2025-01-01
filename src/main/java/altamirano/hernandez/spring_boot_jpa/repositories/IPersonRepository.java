package altamirano.hernandez.spring_boot_jpa.repositories;

import altamirano.hernandez.spring_boot_jpa.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Integer> {
}
