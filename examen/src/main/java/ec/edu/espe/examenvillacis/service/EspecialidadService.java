package ec.edu.espe.examenvillacis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenvillacis.dao.EspecialidadRepository;
import ec.edu.espe.examenvillacis.domain.Especialidad;
import jakarta.transaction.Transactional;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        try {
            return especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la Especialidad: " + e.getMessage(), e);
        }
    }

    public List<Especialidad> obtenerEspecialidadesPorNombre(String nombre) {
        return especialidadRepository.findByNombreContaining(nombre);
    }
}
