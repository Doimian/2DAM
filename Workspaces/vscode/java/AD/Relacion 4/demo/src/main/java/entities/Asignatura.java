package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name="asignatura", catalog = "instituto")
public class Asignatura implements Serializable
{
    private int codigo;
    private String nombre;
    private Integer creditos;
    private Set<Alumno> alumnos = new HashSet<Alumno>(0);

    public Asignatura()
    {

    }
    public Asignatura(int codigo)
    {
        this.codigo = codigo;
    }
    public Asignatura(int codigo, String nombre, Integer creditos, Set<Alumno> alumnos)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.alumnos = alumnos;
    }

    @Id
    @Column(name="codigo", unique=true, nullable=false)
    public int getCodigo()
    {
        return this.codigo;
    }
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    @Column(name="nombre", length = 30)
    public String getNombre()
    {
        return this.nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Column(name="creditos")
    public Integer getCreditos()
    {
        return this.creditos;
    }
    public void setCreditos(Integer creditos)
    {
        this.creditos = creditos;
    }

    @ManyToAny(fetch=FetchType.LAZY)
    @JoinTable
    (
        name="matricula", catalog="instituto",
        joinColumns =
        {
            @JoinColumn(name="cod_asig", nullable = false, updatable = false)
        },
        inverseJoinColumns = 
        {
            @JoinColumn(name="cod_alumno", nullable = false, updatable = false)
        }
    )
    public Set<Alumno> getAlumnos()
    {
        return this.alumnos;
    }
    public void setAlumnos(Set<Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }
}
