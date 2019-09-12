
package com.example.demo;

        import lombok.Data;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;

@Data
@Entity
public class Medico {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    Medico() {}

    Medico(String name, String role) {
        this.name = name;
        this.role = role;
    }
}