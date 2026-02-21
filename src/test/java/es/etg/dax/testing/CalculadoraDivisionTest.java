package es.etg.dax.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.etg.dax.testing.exception.OperacionNoValidaException;

public class CalculadoraDivisionTest {

    @Test
    @DisplayName("Caja negra: división con casos válidos")
    void dividirCasosValidos() throws OperacionNoValidaException {

        assertAll("División",
            () -> assertEquals(5,  Calculadora.dividir(10, 2)),
            () -> assertEquals(4,  Calculadora.dividir(9, 2)),    
            () -> assertEquals(-4, Calculadora.dividir(-9, 2)),
            () -> assertEquals(-4, Calculadora.dividir(9, -2)),
            () -> assertEquals(4,  Calculadora.dividir(-9, -2)),
            () -> assertEquals(0,  Calculadora.dividir(0, 5)),
            () -> assertEquals(5,  Calculadora.dividir(5, 1)),
            () -> assertEquals(-5, Calculadora.dividir(5, -1))
        );
    }

    @Test
    @DisplayName("Caja negra: dividir por cero lanza excepción")
    void dividirPorCeroLanzaExcepcion() {
        var ex = assertThrows(OperacionNoValidaException.class, () -> Calculadora.dividir(4, 0));
        assertEquals(OperacionNoValidaException.MSG, ex.getMessage());
    }
}
