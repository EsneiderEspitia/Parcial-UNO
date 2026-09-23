package edu.uniajc.model;

public class LibroTexto extends Libro {
    private String curso;

    public LibroTexto() {
        super();
        this.curso = "";
    }

    public LibroTexto(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso) {
        super(titulo, autor, numeroEjemplares, numeroEjemplaresPrestados);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String toString() {
        return "LibroTexto [Título: '" + getTitulo() + "', Autor: '" + getAutor() +
                "', Total Ejemplares: " + getNumeroEjemplares() +
                ", Prestados: " + getNumeroEjemplaresPrestados() +
                ", Disponibles: " + (getNumeroEjemplares() - getNumeroEjemplaresPrestados()) +
                ", Curso: '" + curso + "']";
    }
}
