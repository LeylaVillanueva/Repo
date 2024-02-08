package mx.edu.utez.springE.controller;

import mx.edu.utez.springE.model.dto.UsuarioDto;
import mx.edu.utez.springE.model.entity.UsuarioBean;
import mx.edu.utez.springE.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired
    private IUsuario usuarioService;

    @GetMapping("/")
    public List<UsuarioBean> getUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioBean showById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/")
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto) {
        UsuarioBean usuarioSave = usuarioService.save(usuarioDto);
        //segun yo aqui va el generar contrasenia
        return UsuarioDto.builder()
                /*
                private Integer id;
                private String nombre;
                private String contrasenia;
                private boolean estado;

                .id(usuarioSave.getId())
                .nombre(usuarioSave.getNombre())
                .contrasenia(usuarioSave.getContrasenia())
                .estado(usuarioSave.isEstado())

                 */
                .id(usuarioDto.getId())
                .nombre(usuarioDto.getNombre())
                .contrasenia(generarContra())
                .estado(usuarioDto.isEstado())
                .build();
    }

    @PutMapping("/")
    public UsuarioDto update(@RequestBody UsuarioDto usuarioDto) {
        UsuarioBean usuarioUpdate = usuarioService.save(usuarioDto);
        return UsuarioDto.builder()
                .id(usuarioDto.getId())
                .nombre(usuarioDto.getNombre())
                .contrasenia(generarContra())
                .estado(usuarioDto.isEstado())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        UsuarioBean usuario = usuarioService.findById(id);
        usuarioService.delete(usuario);
    }

    public String generarContra(){

        String contraAle = "";
        String arreglo = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/*-+<>,.-_";
        int tamanio = arreglo.length();
        Random rm = new Random();
        //(random.nextInt(0, 9));
        for (int i =0; i<8;i++){
            char c = arreglo.charAt(rm.nextInt(arreglo.length()));
            contraAle += c + "";
        }
        return contraAle;
    }
}
