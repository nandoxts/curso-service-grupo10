package pe.edu.cibertec.curso.service;

import pe.edu.cibertec.curso.dto.CursoDisponibilidadDTO;

import java.util.List;

public interface CursoService {

    CursoDisponibilidadDTO obtenerCurso(Long idCurso);

    List<CursoDisponibilidadDTO> listarCursosPorEstudiante(Long estudianteId);
}
