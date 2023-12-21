package ec.edu.espe.examenvillacis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examenvillacis.domain.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository<Especialidad, String> {

    List<Especialidad> findByNombre(String nombre);

}