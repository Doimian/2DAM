package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Libro {
    @Id
    @Column(length = 10, nullable = false, unique = true)
    private String ISBN;

    @Column(length = 30, nullable = false)
    private String titulo;

    @Column(length = 30, nullable = false)
    private String autor;

    public Libro()
    {

    }
    public Libro(String iSBN, String titulo, String autor) {
        ISBN = iSBN;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
