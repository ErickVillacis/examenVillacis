package ec.edu.espe.examenvillacis.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenvillacis.dao.DocenteRepository;
import ec.edu.espe.examenvillacis.dao.EspecialidadRepository;
import ec.edu.espe.examenvillacis.domain.Docente;
import jakarta.transaction.Transactional;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;
    private final EspecialidadRepository especialidadRepository;

    public DocenteService(DocenteRepository docenteRepository, EspecialidadRepository especialidadRepository) {
        this.docenteRepository = docenteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Docente crearDocente(Docente docente) {
        try {
            // Validaciones
            if (especialidadRepository.existsByCodigo(docente.getCodigoEspecialidad())) {
                Date fechaActual = new Date();
                if (docente.getFechaIngreso().after(fechaActual)) {
                    return docenteRepository.save(docente);
                } else {
                    throw new RuntimeException("La fecha de ingreso debe ser posterior a la actual.");
                }
            } else {
                throw new RuntimeException("La especialidad no está registrada.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el docente: " + e.getMessage(), e);
        }
    }
}