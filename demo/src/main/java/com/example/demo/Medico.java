
package com.example.demo;

        import lombok.Data;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;

@Data
@Entity
public class Medico {

    private @Id @GeneratedValue Long id;
    private String nombre;
    private String especialidad;
    private String cargo;

    Medico() {}

    Medico(String nombre, String especialidad ,String cargo) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cargo = cargo;

    }
}