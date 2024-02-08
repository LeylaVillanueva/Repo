package mx.edu.utez.springE.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuarioDto {
    /*
    Administración de Usuarios:
-Nombre de Usuario (Username): Cadena de caracteres que identifica de forma única a cada usuario.
-Contraseña (Password): Se debe generar una contraseña aleatoria para cada usuario con las siguientes características:
Longitud de 8 caracteres.
Debe incluir caracteres en minúsculas, mayúsculas, números y caracteres especiales.
-Estado: Booleano que indica si está activo o inactivo.
*/
    private Integer id;
    private String nombre;
    private String contrasenia;
    private boolean estado;
}
