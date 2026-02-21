# Respuestas (RA3)

## 1) ¿Qué sentido puede tener este proyecto y para qué lo podrías usar?
Para mí este proyecto sirve para practicar **tests unitarios con JUnit 5** en una clase simple (Calculadora).
Lo usaría para aprender a comprobar automáticamente que los métodos funcionan y que los errores se controlan bien.

---

## 2) Revisa las pruebas de la suma y comenta lo que te parezca de interés
En `CalculadoraTest` veo que:
- Hay pruebas básicas con `assertEquals`.
- También se usa `assertAll` para comprobar varios casos en un mismo test.
- En este tipo de ejercicios a veces hay un test “mal” a propósito para ver cómo se ve un fallo en JUnit.

---

## 3) Estudio de caja negra de la división e implementación en JUnit

### Clases de equivalencia (divisor b)
- b = 0 → inválido → debe lanzar excepción
- b > 0 → válido
- b < 0 → válido

### Valores límite / casos típicos
- b = 0 (frontera)
- b = 1 y b = -1 (cerca del límite)
- a = 0
- caso de truncamiento en división entera: 9/2 = 4

### Casos de prueba
| Caso | a | b | Esperado |
|------|---|---|----------|
| 1 | 10 | 2 | 5 |
| 2 | 9 | 2 | 4 |
| 3 | -9 | 2 | -4 |
| 4 | 9 | -2 | -4 |
| 5 | -9 | -2 | 4 |
| 6 | 0 | 5 | 0 |
| 7 | 5 | 1 | 5 |
| 8 | 5 | -1 | -5 |
| 9 | 4 | 0 | Excepción |