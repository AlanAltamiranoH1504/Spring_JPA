package altamirano.hernandez.spring_boot_jpa;

import altamirano.hernandez.spring_boot_jpa.dto.PersonDTO;
import altamirano.hernandez.spring_boot_jpa.entities.Person;
import altamirano.hernandez.spring_boot_jpa.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t *** LISTA DE PERSONS ***");
        List<Person> persons = (List<Person>) ipersonRepository.buscarPorLenguajedeProgramacion("Java");
        for (var person: persons){
            System.out.println("person = " + person);
        }

        /*System.out.println("\n\t*** PERSONA EN ESPECIFICO ***");
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

        System.out.println("\t*** ACTUALIZACION DE UN REGISTRO EN LA DB ***");
        Person personaActualizar = ipersonRepository.findById(1).orElse(null);
        var nuevosApellidos = "Altamirano Hernandez";
        personaActualizar.setLenguajeDeProgramacion("Java, Spring, Php, Laravel, Node, JS");
        personaActualizar.setApellidos(nuevosApellidos);
        ipersonRepository.save(personaActualizar);
        System.out.println("Person actualizada");

        System.out.println("\t*** ACTUALIZACION DE REGISTRO EN LA DB CON METODO PERSONALIZADO ***");
        System.out.println("Ingresa  el ID del usuario a actualizar: ");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingresa los nuevos lenguajes de programacion: ");
        String lenguajes = scanner.nextLine();
        ipersonRepository.actualizarLenguajes(lenguajes, id);
        System.out.println("ACTUALIZACION DE LENGUAJES DE PROGRAMACION");*/

        /*System.out.println("\t*** ELIMINACION DE REGISTRO EN LA DB (POR ID)");
        System.out.println("Ingresa el ID del usuario a eliminar");
        var id = Integer.parseInt(scanner.nextLine());
        var personaEncontrada = ipersonRepository.findById(id).orElse(null);
        if (personaEncontrada != null){
            ipersonRepository.deleteById(id);
            System.out.println("Persona Eliminada");
        }else{
            System.out.println("Persona no econtrada para eliminacion");
        }

        System.out.println("\t*** ELIMINACION DE REGISTRO EN LA DB (POR PERSONA)");
        System.out.println("Ingresa el id de la persona a eliminar: ");
        var id = Integer.parseInt(scanner.nextLine());
        var persona = ipersonRepository.findById(id).orElse(null);
        if (persona != null) {
            ipersonRepository.delete(persona);
            System.out.println("Person eliminada");
        }else{
            System.out.println("Person no encontrado");
        }

        System.out.println("\t*** ELIMINACION DE REGISTRO EN LA DB (POR METODO PERSONALIZADO)");
        System.out.println("Ingresa el id de la persona a eliminar: ");
        var id = Integer.parseInt(scanner.nextLine());
        ipersonRepository.eliminarPersona(id);
        System.out.println("Persona eliminada con exito");

        System.out.println("\t*** METODO PERSONALIZADO GETNAME BY ID ***");
        var nombrePersona = ipersonRepository.getNameById(1);
        System.out.println("nombrePersona = " + nombrePersona);

        System.out.println("\t*** METODO PERSONALIZADO PARA OBTENER TODOS LOS DE APELLIDOS A-H");
        List<Person> personas = ipersonRepository.getFullApellido("Altamirano Hernandez");
        if (personas != null){
            for(var persona: personas){
                System.out.println("persona = " + persona);
            }
        }else{
            System.out.println("No hay personas con esos apellidos");
        }
        System.out.println("\t*** OBJETOS PERSONALIZADOS DE PERSONA ***");
        var personas = ipersonRepository.findAllClassPerson();
        for (var person: personas){
            System.out.println("person = " + person);
        }

        System.out.println("\t*** OBJETOS PERSONALIZADOS CON LA CLASE DTO");
        List<PersonDTO> personasDTO = ipersonRepository.findAllPersonDTO();
        for (var person: personasDTO){
            System.out.println("person = " + person);
        }

        System.out.println("\t *** LISTA DE NOMBRES ***");
        List<String> nombres = ipersonRepository.getALlNames();
        for (var nombre: nombres){
            System.out.println("nombre = " + nombre);
        }

        System.out.println("NUMERO DE LENGUAJES DE PROGRAMACION");
        int numeroLenguajes = ipersonRepository.numeroDeLenguajes();
        System.out.println("numeroLenguajes = " + numeroLenguajes);*/

        System.out.println("NOMBRES EN MAYUSCULAS");
        List<String> nombres = ipersonRepository.nombreUppercase();
        for (var nombre: nombres){
            System.out.println("nombre = " + nombre);
        }

        System.out.println("NOMBRES EN MINISCULAS");
        List<String> nombresMin = ipersonRepository.nombreLowercase();
        for (var nombre: nombresMin){
            System.out.println("nombre = " + nombre);
        }

        System.out.println("PATRON DE LIKE");
        List<Person> personasApellido = ipersonRepository.personasApellidos("Altamirano Hernandez");
        for (var person: personasApellido){
            System.out.println("person = " + person);
        }

        System.out.println("BTWEEN");
        List<Person> personaBetween = ipersonRepository.personaBetween(1, 3);
        for (var persona: personaBetween){
            System.out.println("persona = " + persona);
        }
    }
}
