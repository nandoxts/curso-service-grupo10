package pe.edu.cibertec.curso.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.curso.dto.CursoDisponibilidadDTO;
import pe.edu.cibertec.curso.exception.RecursoNoEncontradoException;
import pe.edu.cibertec.curso.model.Curso;
import pe.edu.cibertec.curso.repository.CursoRepository;
import pe.edu.cibertec.curso.service.CursoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public CursoDisponibilidadDTO obtenerCurso(Long idCurso) {
        return cursoRepository.buscarPorId(idCurso)
                .map(this::toDisponibilidadDTO)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el curso con id " + idCurso));
    }

    @Override
    public List<CursoDisponibilidadDTO> listarCursosPorEstudiante(Long estudianteId) {
        return cursoRepository.buscarPorEstudiante(estudianteId)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No hay cursos registrados para el estudiante " + estudianteId))
                .stream()
                .map(this::toDisponibilidadDTO)
                .toList();
    }

    private CursoDisponibilidadDTO toDisponibilidadDTO(Curso curso) {
        return CursoDisponibilidadDTO.builder()
                .idCurso(curso.getIdCurso())
                .codigoCurso(curso.getCodigoCurso())
                .nombreCurso(curso.getNombreCurso())
                .vacantesDisponibles(curso.getVacantesDisponibles())
                .prerrequisito(curso.getPrerrequisito())
                .estadoCurso(curso.getEstadoCurso())
                .build();
    }
}
