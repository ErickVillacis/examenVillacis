package ec.edu.espe.examenvillacis.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenvillacis.dao.DocenteMateriaRepository;
import ec.edu.espe.examenvillacis.dao.DocenteRepository;
import ec.edu.espe.examenvillacis.dao.MateriaRepository;
import ec.edu.espe.examenvillacis.domain.Docente;
import ec.edu.espe.examenvillacis.domain.DocenteMateria;
import ec.edu.espe.examenvillacis.domain.Materia;
import jakarta.transaction.Transactional;

@Service
public class PlanificacionService {

    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteMateriaRepository docenteMateriaRepository;

    public PlanificacionService(DocenteRepository docenteRepository, MateriaRepository materiaRepository,
            DocenteMateriaRepository docenteMateriaRepository) {
        this.docenteRepository = docenteRepository;
        this.materiaRepository = materiaRepository;
        this.docenteMateriaRepository = docenteMateriaRepository;
    }

    @Transactional
    public void asignarDocenteAMateria(Long idDocente, Long idMateria) {
        try {
            Docente docente = docenteRepository.findById(idDocente).get();
            Materia materia = materiaRepository.findById(idMateria).get();

            boolean existeAsociacion = docenteMateriaRepository.existsByDocenteAndMateria(docente, materia);
            if (existeAsociacion) {
                throw new RuntimeException("El docente ya está asignado a esta materia");
            }

            DocenteMateria docenteMateria = new DocenteMateria();
            docenteMateria.setDocente(docente);
            docenteMateria.setMateria(materia);
            docenteMateriaRepository.save(docenteMateria);
        } catch (Exception e) {
            throw new RuntimeException("Error al asignar docente a materia: " + e.getMessage(), e);
        } 
    }
}