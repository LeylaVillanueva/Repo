package mx.edu.utez.springE.service.impl;

import mx.edu.utez.springE.model.dao.PersonaDao;
import mx.edu.utez.springE.model.dao.UsuarioDao;
import mx.edu.utez.springE.model.dto.PersonaDto;
import mx.edu.utez.springE.model.entity.PersonaBean;
import mx.edu.utez.springE.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplPersona implements IPersona {
    //
    @Autowired
    private PersonaDao personaDao;
    //
    @Override
    public PersonaBean save(PersonaDto personaDto) {
        PersonaBean persona = PersonaBean.builder()
                .id(personaDto.getId())
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .direccion(personaDto.getDireccion())
                .contacto(personaDto.getContacto())
                .extra(personaDto.getExtra())
                .build();

        return personaDao.save(persona);
    }

    @Override
    public PersonaBean findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public List<PersonaBean> findAll() {
        return (List<PersonaBean>) personaDao.findAll();
    }

    @Override
    public void delete(PersonaBean persona) {
        personaDao.delete(persona);
    }
}
