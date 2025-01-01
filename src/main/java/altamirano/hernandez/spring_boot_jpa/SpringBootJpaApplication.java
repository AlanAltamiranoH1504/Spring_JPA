package altamirano.hernandez.spring_boot_jpa;

import altamirano.hernandez.spring_boot_jpa.entities.Person;
import altamirano.hernandez.spring_boot_jpa.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

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
        System.out.println("\n\t *** LISTA DE PERSONS ***");
        List<Person> persons = (List<Person>) ipersonRepository.buscarPorLenguajedeProgramacion("Java");
        for (var person: persons){
            System.out.println("person = " + person);
        }

        System.out.println("\n\t*** PERSONA EN ESPECIFICO ***");
        var personaEncontrada = ipersonRepository.buscarPorNombre("Alan");
        System.out.println("personaEncontrada = " + personaEncontrada);

        System.out.println("\n\t*** BUSQUEDA POR APELLIDOS ***");
        Person personaEncontradoPorApellidos = ipersonRepository.buscarPorApellidos("Altamirano Hernandez");
        System.out.println("personaEncontradoPorApellidos = " + personaEncontradoPorApellidos);

        System.out.println("\n\t*** BUSQUEDA POR ID ***");
        Person personaPorId = ipersonRepository.findById(10).orElse(null);
        System.out.println("personaPorId = " + personaPorId);

        System.out.println("\n\t*** CREACION (INSERCION) NUEVO OBJETO EN LA DB ***");
        Person person1 = new Person("Raquel", "Hernandez Hernandez", "Phyton, React, Angular");
        ipersonRepository.save(person1);
        System.out.println("Objeto guardado en la db");
    }
}
