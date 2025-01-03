package altamirano.hernandez.spring_boot_jpa.repositories;

import altamirano.hernandez.spring_boot_jpa.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import altamirano.hernandez.spring_boot_jpa.dto.PersonDTO;

import java.util.List;

public interface IPersonRepository extends CrudRepository<Person, Integer> {
    //Definimos metodo personalizado (siguiendo la nomenclatura)
    List<Person> findByLenguajeDeProgramacion(String lenguajeDeProgramacion);

    //Definimos metodo personalizado que no sigue la nomenclatura
    @Query("SELECT p FROM Person p WHERE p.lenguajeDeProgramacion =:lenguaje")
    List<Person> buscarPorLenguajedeProgramacion(@Param("lenguaje") String lenguaje);

    //Consulta Personalizada → Por Nombre
    @Query("SELECT p FROM Person p WHERE p.nombre =:nombre")
    Person buscarPorNombre(@Param("nombre") String nombre);

    //Consulta Personalizada → Por Apellidos
    @Query("SELECT p FROM Person p WHERE p.apellidos =:apellidos")
    Person buscarPorApellidos(@Param("apellidos") String apellidos);

    //Consulta Personalizada para Actualizar Lenguajes de Programacion
    @Modifying
    @Transactional
    @Query("UPDATE Person p SET p.lenguajeDeProgramacion =:lenguajes WHERE p.id =:id")
    public void actualizarLenguajes(@Param("lenguajes") String lenguajes, @Param("id") int id);

    //Consulta personalizada para eliminar una persona
    @Modifying
    @Transactional
    @Query("DELETE FROM Person p WHERE p.id =:id")
    public void eliminarPersona(@Param("id") int id);

    //Consulta personalizada para obtener el nombre segun el id
    @Query("SELECT CONCAT(p.nombre, ' ', p.apellidos) FROM Person p WHERE p.id =:id")
    String getNameById(@Param("id") int id);

    //Consulta personalizada para obtener todos los que tengan apellidos Altamirano Hernandez
    @Query("SELECT p FROM Person p WHERE p.apellidos =:apellidos")
    List<Person>getFullApellido(@Param("apellidos") String apellidos);

    //Consulta Personalizada para obtener objetos de clase Person
    @Query("SELECT new Person (p.nombre, p.apellidos, p.lenguajeDeProgramacion) FROM Person p")
    List<Person> findAllClassPerson();

    //Consulta que regresa clase DTO
    @Query("SELECT new altamirano.hernandez.spring_boot_jpa.dto.PersonDTO (CONCAT(p.nombre, ' ', p.apellidos) , p.lenguajeDeProgramacion) FROM Person p")
    List<PersonDTO> findAllPersonDTO();

    //Consulta que lista todos los nombre de los Person
    @Query("SELECT DISTINCT p.nombre FROM Person p")
    List<String> getALlNames();

    //Consulta que cuenta los lenguajes de programacion
    @Query("SELECT COUNT(p.lenguajeDeProgramacion) FROM Person p")
    public int numeroDeLenguajes();

    //Consulta que regresa los nombre en mayusculas
    @Query("SELECT UPPER(CONCAT(p.nombre, ' ', p.apellidos )) FROM Person p")
    public List<String> nombreUppercase();

    //Consulta que regresa los nombre en minusculas
    @Query("SELECT LOWER(CONCAT(p.nombre, ' ', p.apellidos )) FROM Person p")
    public List<String> nombreLowercase();

    //Consulta que regresa los Person que tengan apellidos iniciando con Altamirano Hernnandez
    @Query("SELECT p FROM Person p WHERE p.apellidos LIKE :apellidos")
    public List<Person> personasApellidos(@Param("apellidos") String apellidos);

    //Consulta que regresa los Person que tengan ID entre 1 y 3
    @Query("SELECT p FROM Person p WHERE p.id BETWEEN :num1 AND :num2")
    public List<Person> personaBetween(@Param("num1") int num1, @Param("num2") int num2);
}
