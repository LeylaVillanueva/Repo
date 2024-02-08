package mx.edu.utez.springE.service;

import mx.edu.utez.springE.model.dto.UsuarioDto;
import mx.edu.utez.springE.model.entity.UsuarioBean;

import java.util.List;

public interface IUsuario {

    UsuarioBean save(UsuarioDto usuario);

    UsuarioBean findById(Integer id);

    List<UsuarioBean> findAll();

    void delete(UsuarioBean usuario);

}
