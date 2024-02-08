package mx.edu.utez.springE.controller;

import mx.edu.utez.springE.model.dto.PersonaDto;
import mx.edu.utez.springE.model.dto.UsuarioDto;
import mx.edu.utez.springE.model.entity.PersonaBean;
import mx.edu.utez.springE.model.entity.UsuarioBean;
import mx.edu.utez.springE.service.IPersona;
import mx.edu.utez.springE.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/persona")
public class PersonaController {
    @Autowired
    private IPersona personaService;
    //
    @GetMapping("/")
    public List<PersonaBean> getPersona() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public PersonaBean showById(@PathVariable Integer id) {
        return personaService.findById(id);
    }

    @PostMapping("/")
    public PersonaDto create(@RequestBody PersonaDto personaDto) {
        PersonaBean personaSave = personaService.save(personaDto);
        //segun yo aqui va el generar contrasenia
        return PersonaDto.builder()
                /*
                private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Long contacto;
    private String extra;
                 */
                .id(personaDto.getId())
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .direccion(personaDto.getDireccion())
                .contacto(personaDto.getContacto())
                .extra(personaDto.getExtra())
                .build();
    }

    @PutMapping("/")
    public PersonaDto update(@RequestBody PersonaDto personaDto) {
        PersonaBean personaUpdate = personaService.save(personaDto);
        return PersonaDto.builder()
                .id(personaDto.getId())
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .direccion(personaDto.getDireccion())
                .contacto(personaDto.getContacto())
                .extra(personaDto.getExtra())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        PersonaBean persona = personaService.findById(id);
        personaService.delete(persona);
    }
}
