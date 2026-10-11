package pe.edu.cibertec.curso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CursoServiceApplicationTests {

    @Test
    void clasePrincipalExiste() {
        // El servicio depende de Eureka/Config en ejecucion; aqui solo se valida la clase principal.
        assertNotNull(new CursoServiceApplication());
    }
}
