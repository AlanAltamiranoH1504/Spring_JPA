package altamirano.hernandez.spring_boot_jpa.repositories;

import altamirano.hernandez.spring_boot_jpa.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import altamirano.hernandez.spring_boot_jpa.dto.PersonDTO;

import java.util.List;
import java.util.Objects;

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

    //Consulta que ordena los nombres por oden alfabetico
    @Query("SELECT p FROM Person p ORDER BY p.nombre ASC, p.lenguajeDeProgramacion ASC")
    public List<Person> ordenarPorNombres();

    //Consulta que ordena por lenguajes de programacion
    @Query("SELECT p FROM Person p ORDER BY p.lenguajeDeProgramacion")
    public List<Person> ordenarPorLenguajes();

    //Consulta que saca el total de registros en la tabla
    @Query("SELECT COUNT (p) FROM Person p")
    public int totalRegistros();

    //Consultamos el ID mas grande
    @Query("SELECT MAX (p.id) FROM Person p")
    public int idMaximo();

    //Consulta el id minimo
    @Query("SELECT MIN (p.id) FROM Person p")
    public int idMinimo();

    //Consulta que trae el largo de los nombres
    @Query("SELECT LENGTH(p.nombre) FROM Person p")
    public List<Integer> nombreMasLargo();

    //Consulta que trae el nmbre mas corto
    @Query("SELECT MIN (LENGTH(p.nombre)) FROM Person p")
    public Integer getMinLengthNombre();

    //Consulta que trae el nombre mas largo
    @Query("SELECT MAX (LENGTH(p.nombre)) FROM Person p")
    public int getMaxLengthNombre();

    //Consulta que da el promedio del largo de los nombres
    @Query("SELECT AVG (LENGTH(p.nombre)) FROM Person p")
    public double getAvgLargoNombres();

    //Consulta que da el avg del largo de los apellidos
    @Query("SELECT AVG(LENGTH(p.apellidos)) FROM Person p")
    public double getAvgLargoApellidos();

    //Subconsulta que obtiene los registros con el nombre mas corto
    @Query("SELECT p.nombre, LENGTH(p.nombre) FROM Person p WHERE LENGTH(p.nombre) = (SELECT MIN (LENGTH(p.nombre))FROM Person p)")
    List<Object[]> getShortNames();

    //Subconsulya que obtiene el ultimo registro
    @Query("SELECT p.id, p.nombre FROM Person p WHERE p.id = (SELECT MAX (p.id) FROM Person p)")
    public List<Object[]> getUltimoRegistro();

    //Subcolta con where int
    @Query("SELECT p FROM Person p WHERE p.id IN :ids")
    public List<Person> getPersons(@Param("ids") List<Integer> ids);
}
