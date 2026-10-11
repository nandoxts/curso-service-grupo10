package pe.edu.cibertec.curso.repository;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.curso.model.Curso;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Repositorio en memoria con los datos semilla del catalogo.
 */
@Repository
public class CursoRepository {

    private final Map<Long, Curso> cursos = new ConcurrentHashMap<>();
    private final Map<Long, List<Long>> cursosPorEstudiante = new ConcurrentHashMap<>();

    public CursoRepository() {
        guardar(new Curso(1L, "DAW201", "Desarrollo de Aplicaciones Web II", "T6AA", 4, 120.00, 15, "DAW101", "ABIERTO"));
        guardar(new Curso(2L, "BDA201", "Base de Datos Avanzada", "T6AB", 3, 120.00, 8, "BDA101", "ABIERTO"));
        guardar(new Curso(3L, "ARQ301", "Arquitectura de Software", "T6AC", 4, 120.00, 0, "DAW201", "CERRADO"));
        guardar(new Curso(4L, "MOV201", "Desarrollo de Aplicaciones Moviles", "T6AD", 3, 120.00, 5, "Ninguno", "ABIERTO"));

        cursosPorEstudiante.put(1001L, List.of(1L, 2L, 4L));
        cursosPorEstudiante.put(1002L, List.of(1L, 3L));
    }

    public Optional<Curso> buscarPorId(Long idCurso) {
        return Optional.ofNullable(cursos.get(idCurso));
    }

    public Optional<List<Curso>> buscarPorEstudiante(Long estudianteId) {
        return Optional.ofNullable(cursosPorEstudiante.get(estudianteId))
                .map(ids -> ids.stream()
                        .map(cursos::get)
                        .filter(Objects::nonNull)
                        .toList());
    }

    private void guardar(Curso curso) {
        cursos.put(curso.getIdCurso(), curso);
    }
}
