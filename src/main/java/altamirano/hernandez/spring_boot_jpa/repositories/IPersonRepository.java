package altamirano.hernandez.spring_boot_jpa.repositories;

import altamirano.hernandez.spring_boot_jpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
}
