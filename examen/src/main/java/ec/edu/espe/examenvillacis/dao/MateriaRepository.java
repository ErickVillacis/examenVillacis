package ec.edu.espe.examenvillacis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examenvillacis.domain.Materia;

import java.util.List;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long> {

    List<Materia> findByNombre(String nombre);

}
