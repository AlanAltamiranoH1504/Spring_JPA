package altamirano.hernandez.spring_boot_jpa.dto;

public class PersonDTO {
    private String nombreCompleto;
    private String lenguajesProgramacion;

    public PersonDTO(String nombreCompleto, String lenguajesProgramacion) {
        this.nombreCompleto = nombreCompleto;
        this.lenguajesProgramacion = lenguajesProgramacion;
    }

    //Metodos GET y SET
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getLenguajesProgramacion() {
        return lenguajesProgramacion;
    }
    public void setLenguajesProgramacion(String lenguajesProgramacion) {
        this.lenguajesProgramacion = lenguajesProgramacion;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "PersonDTO{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", lenguajesProgramacion='" + lenguajesProgramacion + '\'' +
                '}';
    }
}
