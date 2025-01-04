package altamirano.hernandez.spring_boot_jpa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    //Atributos del entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    @Column(name = "lenguaje_de_programacion")
    private String lenguajeDeProgramacion;
    @Embedded
    private Audit audit = new Audit();

    //Constructores
    public Person(){

    }
    public Person(String nombre, String apellidos, String lenguajeDeProgramacion){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.lenguajeDeProgramacion = lenguajeDeProgramacion;
    }
    public Person(int id, String nombre, String apellidos, String lenguajeDeProgramacion){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.lenguajeDeProgramacion = lenguajeDeProgramacion;
    }

    //Metodos GET y SET
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getLenguajeDeProgramacion() {
        return lenguajeDeProgramacion;
    }
    public void setLenguajeDeProgramacion(String lenguajeDeProgramacion) {
        this.lenguajeDeProgramacion = lenguajeDeProgramacion;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", lenguajeDeProgramacion='" + lenguajeDeProgramacion + '\'' +
                ", createdAt=" + audit.getCreatedAt() +
                ", updatedAt=" + audit.getUpdatedAt() +
                ", deletedAt=" + audit.getDeletedAt() +
                '}';
    }
}
