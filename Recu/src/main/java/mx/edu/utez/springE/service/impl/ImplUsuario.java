package mx.edu.utez.springE.service.impl;

import mx.edu.utez.springE.model.dao.UsuarioDao;
import mx.edu.utez.springE.model.dto.UsuarioDto;
import mx.edu.utez.springE.model.entity.UsuarioBean;
import mx.edu.utez.springE.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class ImplUsuario implements IUsuario {
    //ESTA ES LA QUE INTERACTUA CON POSTAMAN creo idk
    @Autowired
    private UsuarioDao usuarioDao;
    //guardar
    @Override
    public UsuarioBean save(UsuarioDto usuarioDto) {
        UsuarioBean usuario = UsuarioBean.builder()
                .id(usuarioDto.getId())
                .nombre(usuarioDto.getNombre())
                .contrasenia(generarContra2())
                .estado(String.valueOf(usuarioDto.isEstado()))
                .build();
        return usuarioDao.save(usuario);
    }
    //buscar por id
    @Override
    public UsuarioBean findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }
    //obtener todos
    @Override
    public List<UsuarioBean> findAll() {
        return (List<UsuarioBean>) usuarioDao.findAll();
    }
    //eliminar
    @Override
    public void delete(UsuarioBean usuario) {
        usuarioDao.delete(usuario);
    }

    public String generarContra2(){

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
