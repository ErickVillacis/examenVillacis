package ec.edu.espe.examenvillacis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examenvillacis.domain.Docente;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Long> {

    List<Docente> findByNombre(String nombre);

    List<Docente> findByCodigoEspecialidad(String codigoEspecialidad);

    List<Docente> findByNombreAndCodigoEspecialidad(String nombre, String codigoEspecialidad);

}
