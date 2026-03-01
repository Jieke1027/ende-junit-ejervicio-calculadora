# Testing con JUnit - Respuestas

**Jieke Zhuang 1DAW** 

## 1) ¿Que sentido puede tener este proyecto y para que lo podrias usar?

Este proyecto es un ejemplo de **pruebas unitarias** (tests) con **JUnit 5**. En una empresa se podria usar para:

- Comprobar automaticamente que los metodos (sumar, dividir, etc.) funcionan bien.
- Detectar errores rapido cuando se cambia el codigo (evita "romper" funcionalidades antiguas).
- Ejecutar los tests en cada entrega (por ejemplo, con `mvn test` o integracion continua) para asegurar calidad.

## 2) Revisa las pruebas de la suma y comenta lo que te parezca de interes

- Las pruebas estan en `src/test/java` y prueban metodos **static** de `Calculadora`.
- Hay tests simples con `assertEquals(...)` (un caso concreto).
- Hay un test agrupado con `assertAll(...)` que ejecuta varios casos de suma en el mismo test.
- En el proyecto original habia un test `sumarPositivosMal()` con el valor esperado mal (ponia 4 en vez de 5). Si un test esta mal, el proyecto fallara al ejecutar `mvn test`. En esta entrega se ha corregido.

## 3) Estudio de caja negra de la division e implementacion en JUnit

### Entradas y salida

- Entradas: `a` (dividendo, `int`) y `b` (divisor, `int`).
- Salida:
  - Si `b != 0` devuelve `a / b` (division entera).
  - Si `b == 0` lanza `OperacionNoValidaException`.

### Clases de equivalencia

**Para `a`:**
- CEa1: `a < 0`
- CEa2: `a = 0`
- CEa3: `a > 0`

**Para `b`:**
- CEb1: `b < 0`
- CEb2: `b = 0` (invalida -> excepcion)
- CEb3: `b > 0`

### Valores limite

- Para `a`: `-1, 0, 1`
- Para `b`: `-1, 0, 1` (el 0 es el limite invalido)

### Conjetura de errores (errores tipicos)

- Division por 0.
- Signos (+/-).
- Truncamiento de la division entera (ejemplo: `9/2 = 4`).

### Casos de prueba (CP)

| CP  | a  | b  | Esperado |
|-----|---:|---:|----------|
| CP1 |  9 |  2 | 4 |
| CP2 | -9 |  2 | -4 |
| CP3 |  9 | -2 | -4 |
| CP4 | -9 | -2 | 4 |
| CP5 |  0 |  5 | 0 |
| CP6 |  0 | -5 | 0 |
| CP7 |  4 |  0 | Excepcion |
| CP8 | -4 |  0 | Excepcion |
| CP9 |  0 |  0 | Excepcion |

### Implementacion en JUnit

Los CP anteriores se han implementado en `CalculadoraDivisionTest.java` con:

- `assertEquals(...)` para los casos validos.
- `assertThrows(...)` para los casos invalidos (b = 0).