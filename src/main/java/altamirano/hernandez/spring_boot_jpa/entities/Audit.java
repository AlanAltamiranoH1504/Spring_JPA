package altamirano.hernandez.spring_boot_jpa.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//Definimos que una clase embebible
@Embeddable
public class Audit {
    //Atributos de la clase
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_ad")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    //Eventos del ciclo de vida
    @PrePersist
    public void prePersist(){
        System.out.println("EVENTO DEL CICLO DE VIDA → ANTES DE HACER INSERT");
        this.createdAt = LocalDateTime.now();
    }

    @PostPersist
    public void postPersist(){
        System.out.println("EVENTO DEL CICLO DE VIDA → DESPUES DE HACER INSERT");
        System.out.println("Persona Guardada en la DB");
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("EVENTO DEL CICLO DE VIDA → ANTES DE HACER UPDATE");
        this.updatedAt = LocalDateTime.now();
    }
    @PostUpdate
    public void postUpdate(){
        System.out.println("EVENTO DEL CICLO DE VIDA → DESPUES DE HACER UPDATE");
        System.out.println("Persona Actualizada en la DB");
    }

    @PreRemove
    public void preDelete(){
        System.out.println("EVENTO DEL CICLO DE VIDA → ANTES DE HACER DELETE");
        this.deletedAt = LocalDateTime.now();
    }
    @PostRemove
    public void postRemove(){
        System.out.println("EVENTO DEL CICLO DE VIDA → DESPUES DE HACER DELETE");
        System.out.println("Persona Eliminada en la DB");
    }

    //Metodos GET y SET
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
