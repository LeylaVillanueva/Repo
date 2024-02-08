package mx.edu.utez.springE.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
@Builder
@Table(name = "persona")
public class PersonaBean {
    /*
    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Long contacto;
    private String extra;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "contacto", nullable = false)
    private Long contacto;
    @Column(name = "exra", nullable = false)
    private String extra;
}
