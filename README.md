# curso-service-grupo10

> **EduSmart Campus – Microservicios con Spring Cloud** · Laboratorio T2 (Fila B) · Grupo 10
> Java 25 · Spring Boot 4.1.1 · Spring Cloud 2025.1.3 · Maven

Microservicio de **catálogo de cursos**: vacantes por sección, prerrequisitos y costo por crédito (Pregunta 1). Se registra en Eureka como `CURSO-SERVICE-GRUPO10` y es consumido por `matricula-service-grupo10` mediante `@FeignClient`.

| Dato | Valor |
|---|---|
| Puerto | `8086` |
| Nombre en Eureka | `CURSO-SERVICE-GRUPO10` |
| Dependencias | Spring Web, Eureka Discovery Client, Lombok |
| Persistencia | En memoria (`ConcurrentHashMap`) |

## Endpoints

| Método | URL | Respuesta |
|---|---|---|
| GET | `/api/v1/cursos/{idCurso}` | `CursoDisponibilidadDTO` |
| GET | `/api/v1/cursos/estudiante/{estudianteId}` | `List<CursoDisponibilidadDTO>` |

Vía Gateway: `http://localhost:8070/api/v1/cursos/1`. Si el recurso no existe responde **404** con `{ timestamp, status, error, mensaje, path }`.

## Datos semilla

| idCurso | Código | Nombre | Sección | Créditos | Vacantes | Prerrequisito | Estado |
|---|---|---|---|---|---|---|---|
| 1 | DAW201 | Desarrollo de Aplicaciones Web II | T6AA | 4 | 15 | DAW101 | ABIERTO |
| 2 | BDA201 | Base de Datos Avanzada | T6AB | 3 | 8 | BDA101 | ABIERTO |
| 3 | ARQ301 | Arquitectura de Software | T6AC | 4 | 0 | DAW201 | CERRADO |
| 4 | MOV201 | Desarrollo de Aplicaciones Móviles | T6AD | 3 | 5 | Ninguno | ABIERTO |

Cursos por estudiante: `1001 → [1, 2, 4]` · `1002 → [1, 3]`

## Estructura

```
pe.edu.cibertec.curso
├── controller/   CursoController
├── dto/          CursoDisponibilidadDTO
├── model/        Curso
├── repository/   CursoRepository (seed en memoria)
├── service/      CursoService + impl/CursoServiceImpl
└── exception/    RecursoNoEncontradoException, GlobalExceptionHandler
```

## Ejecutar

```bash
./mvnw spring-boot:run      # requiere discovery-server en :8761
```
