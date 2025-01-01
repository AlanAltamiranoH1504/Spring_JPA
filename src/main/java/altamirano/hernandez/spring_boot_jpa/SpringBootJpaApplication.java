package altamirano.hernandez.spring_boot_jpa;

import altamirano.hernandez.spring_boot_jpa.entities.Person;
import altamirano.hernandez.spring_boot_jpa.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {
    //Inyectamos el repositorio
    @Autowired
    private IPersonRepository ipersonRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Person> persons = (List<Person>) ipersonRepository.findAll();
        for (var person: persons){
            System.out.println("person = " + person);
        }
    }
}
