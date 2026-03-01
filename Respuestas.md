# Testing con JUnit - Respuestas

**Jieke Zhuang 1DAW** 

## 1) ¿Que sentido puede tener este proyecto y para que lo podrias usar?

Este proyecto es un ejemplo de **pruebas unitarias** (tests) con **JUnit 5**. En una empresa se podria usar para:

- Comprobar automaticamente que los metodos (sumar, dividir, etc.) funcionan bien.
- Detectar errores rapido cuando se cambia el codigo (evita "romper" funcionalidades antiguas).
- Ejecutar los tests en cada entrega (por ejemplo, con `mvn test` o integracion continua) para asegurar calidad.

## 2) Revisa las pruebas de la suma y comenta lo que te parezca de interes

En CalculadoraTest hay pruebas de la suma con assertEquals y una prueba agrupada con assertAll.
sumarPositivos y sumarPositivosCorregido comprueban el mismo caso (2+3=5), por lo que es redundante y se podria dejar solo una o cambiarla por otro caso.
En la clase se crea un objeto Calculadora, pero no se utiliza, ya que los metodos se llaman de forma estatica (Calculadora.sumar(...)).
La prueba sumar usa assertAll para validar varios casos en un solo test y añade mensajes para entender que caso falla.
Como mejora de organizacion, separaria las pruebas de division (por ejemplo, la division por cero) en otra clase de test.

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