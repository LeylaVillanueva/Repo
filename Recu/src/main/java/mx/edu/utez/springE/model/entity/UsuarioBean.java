package mx.edu.utez.springE.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
@Builder
@Table(name = "usuario")

public class UsuarioBean {
    /*
    private Integer id;
    private String nombre;
    private String contrasenia;
    private boolean estado;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
    @Column(name = "contrasenia", nullable = false, unique = true, length = 8)
    private String contrasenia;
    @Column(name = "estado", nullable = false)
    private String estado;


/*
    @OneToOne(mappedBy = "branchBean", cascade = CascadeType.ALL) //uno a uno
    @JsonIgnore
    private EmployeeBean employeeBean;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "branchBean")// uno a muchos
    private Set<ClientBean> clients = new HashSet<>();
*/

}
