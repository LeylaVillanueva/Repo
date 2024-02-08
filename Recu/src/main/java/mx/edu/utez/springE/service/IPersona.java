package mx.edu.utez.springE.service;

import mx.edu.utez.springE.model.dto.PersonaDto;
import mx.edu.utez.springE.model.dto.UsuarioDto;
import mx.edu.utez.springE.model.entity.PersonaBean;
import mx.edu.utez.springE.model.entity.UsuarioBean;

import java.util.List;

public interface IPersona {
    PersonaBean save(PersonaDto persona);

    PersonaBean findById(Integer id);

    List<PersonaBean> findAll();

    void delete(PersonaBean persona);
}
