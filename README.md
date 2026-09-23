# Parcial UNO - Programación II (G411) - UNIAJC

**Institución:** Institución Universitaria Antonio José Camacho (UNIAJC)  
**Asignatura:** Programación II 
**Integrantes:** Esneider Espitia, Alexander Velasco
**Tema:** POO - Abstracción, Encapsulamiento y Herencia con Maven + GIT  
**Arquitectura del Proyecto:** Maven Standard Directory Layout  

---

## Descripción del Proyecto

Sistema de gestión de biblioteca desarrollado en Java aplicando los cuatro pilares de la Programación Orientada a Objetos (POO), con énfasis en:
- **Abstracción:** Modelado de entidades del mundo real (`Libro`, `LibroTexto`, `LibroTextoUNIAC`, `Novela`).
- **Encapsulamiento:** Ocultamiento de información mediante atributos privados y métodos de acceso (`getters` / `setters`), controlando la consistencia del estado.
- **Herencia:** Reutilización y jerarquización de código a través de la relación de especialización `is-a` (es-un).
- **Polimorfismo / Sobreescritura:** Redefinición del método `toString()` en cada subclase para representación personalizada.

---

##Diagrama UML de Clases

```mermaid
classDiagram
    class Libro {
        -String titulo
        -String autor
        -int numeroEjemplares
        -int numeroEjemplaresPrestados
        +Libro()
        +Libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados)
        +getTitulo() String
        +setTitulo(String titulo) void
        +getAutor() String
        +setAutor(String autor) void
        +getNumeroEjemplares() int
        +setNumeroEjemplares(int numeroEjemplares) void
        +getNumeroEjemplaresPrestados() int
        +setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados) void
        +prestamo() boolean
        +devolucion() boolean
        +toString() String
    }

    class LibroTexto {
        -String curso
        +LibroTexto()
        +LibroTexto(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso)
        +getCurso() String
        +setCurso(String curso) void
        +toString() String
    }

    class LibroTextoUNIAC {
        -String facultad
        +LibroTextoUNIAC()
        +LibroTextoUNIAC(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso, String facultad)
        +getFacultad() String
        +setFacultad(String facultad) void
        +toString() String
    }

    class Novela {
        -String tipo
        +Novela()
        +Novela(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String tipo)
        +getTipo() String
        +setTipo(String tipo) void
        +toString() String
    }

    Libro <|-- LibroTexto : Herencia (extends)
    LibroTexto <|-- LibroTextoUNIAC : Herencia (extends)
    Libro <|-- Novela : Herencia (extends)
```

---
