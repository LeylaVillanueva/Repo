package mx.edu.utez.springE.model.dao;

import mx.edu.utez.springE.model.entity.PersonaBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<PersonaBean, Integer> {
}
