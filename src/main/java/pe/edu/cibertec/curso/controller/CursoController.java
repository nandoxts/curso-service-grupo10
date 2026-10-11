package pe.edu.cibertec.curso.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.curso.dto.CursoDisponibilidadDTO;
import pe.edu.cibertec.curso.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping("/{idCurso}")
    public CursoDisponibilidadDTO obtenerCurso(@PathVariable("idCurso") Long idCurso) {
        return cursoService.obtenerCurso(idCurso);
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<CursoDisponibilidadDTO> listarCursosPorEstudiante(@PathVariable("estudianteId") Long estudianteId) {
        return cursoService.listarCursosPorEstudiante(estudianteId);
    }
}
