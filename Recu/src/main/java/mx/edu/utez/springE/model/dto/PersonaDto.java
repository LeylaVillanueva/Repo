package mx.edu.utez.springE.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonaDto {
    /*
    nombres, apellidos, dirección, contacto, etc.
     */
    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Long contacto;
    private String extra;
}
