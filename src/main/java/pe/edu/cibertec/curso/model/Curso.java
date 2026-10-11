package pe.edu.cibertec.curso.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad interna del catalogo de cursos (no se expone directamente al cliente).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    private Long idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private String seccion;
    private Integer creditos;
    private Double costoPorCredito;
    private Integer vacantesDisponibles;
    private String prerrequisito;
    private String estadoCurso;
}
