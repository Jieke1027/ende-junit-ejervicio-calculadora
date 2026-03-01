package es.etg.dax.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.etg.dax.testing.exception.OperacionNoValidaException;


public class CalculadoraDivisionTest {

    // --- Casos validos (b != 0) ---

    @Test
    @DisplayName("CP1: 9 / 2 = 4 (division entera)")
    void CP1_dividir_9_entre_2_da_4() throws OperacionNoValidaException {
        assertEquals(4, Calculadora.dividir(9, 2));
    }

    @Test
    @DisplayName("CP2: -9 / 2 = -4")
    void CP2_dividir_menos9_entre_2_da_menos4() throws OperacionNoValidaException {
        assertEquals(-4, Calculadora.dividir(-9, 2));
    }

    @Test
    @DisplayName("CP3: 9 / -2 = -4")
    void CP3_dividir_9_entre_menos2_da_menos4() throws OperacionNoValidaException {
        assertEquals(-4, Calculadora.dividir(9, -2));
    }

    @Test
    @DisplayName("CP4: -9 / -2 = 4")
    void CP4_dividir_menos9_entre_menos2_da_4() throws OperacionNoValidaException {
        assertEquals(4, Calculadora.dividir(-9, -2));
    }

    @Test
    @DisplayName("CP5: 0 / 5 = 0")
    void CP5_dividir_0_entre_5_da_0() throws OperacionNoValidaException {
        assertEquals(0, Calculadora.dividir(0, 5));
    }

    @Test
    @DisplayName("CP6: 0 / -5 = 0")
    void CP6_dividir_0_entre_menos5_da_0() throws OperacionNoValidaException {
        assertEquals(0, Calculadora.dividir(0, -5));
    }

    // --- Casos invalidos (b == 0) ---

    @Test
    @DisplayName("CP7: 4 / 0 lanza OperacionNoValidaException")
    void CP7_dividir_4_entre_0_lanza_excepcion() {
        var ex = assertThrows(OperacionNoValidaException.class, () -> Calculadora.dividir(4, 0));
        assertEquals(OperacionNoValidaException.MSG, ex.getMessage());
    }

    @Test
    @DisplayName("CP8: -4 / 0 lanza OperacionNoValidaException")
    void CP8_dividir_menos4_entre_0_lanza_excepcion() {
        assertThrows(OperacionNoValidaException.class, () -> Calculadora.dividir(-4, 0));
    }
}
