package ec.edu.espe.examenvillacis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examenvillacis.domain.Docente;
import ec.edu.espe.examenvillacis.domain.DocenteMateria;
import ec.edu.espe.examenvillacis.domain.DocenteMateriaId;
import ec.edu.espe.examenvillacis.domain.Materia;

@Repository
public interface DocenteMateriaRepository extends CrudRepository<DocenteMateria, DocenteMateriaId> {

    List<DocenteMateria> findByIdCodigoDocente(Long codigoDocente);

    boolean existsByDocenteAndMateria(Docente docente, Materia materia);

}
