package mx.edu.utez.springE.model.dao;

import mx.edu.utez.springE.model.entity.UsuarioBean;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<UsuarioBean, Integer> {
}
