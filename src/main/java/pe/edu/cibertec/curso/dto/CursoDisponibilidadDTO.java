package pe.edu.cibertec.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoDisponibilidadDTO {

    private Long idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private Integer vacantesDisponibles;
    private String prerrequisito;
    private String estadoCurso;
}
