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
@Table(name = "alumno", catalog = "instituto")
public class Alumno implements Serializable{
    
    private int codigo;
    private String nombre;
    private String apellidos;
    private String tfno;
    private Set<Asignatura> asignaturas = new HashSet<Asignatura>(0);

    public Alumno()
    {

    }

    public Alumno(int codigo)
    {
        this.codigo = codigo;
    }
    public Alumno(int codigo, String nombre, String apellidos, String tfno, Set<Asignatura> asignaturas)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tfno = tfno;
        this.asignaturas = asignaturas;
    }

    //Anotaciones
    @Id
    @Column(name="codigo",unique=true,nullable=false)
    public int getCodigo()
    {
        return this.codigo;
    }
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    @Column(name="nombre", length = 15)
    public String getNombre()
    {
        return this.nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Column(name="apellidos",length=20)
    public String getApellidos()
    {
        return this.apellidos;
    }
    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    @Column(name="tfno", length = 9)
    public String getTfno()
    {
        return this.tfno;
    }
    public void setTfno(String tfno)
    {
        this.tfno = tfno;
    }

    @ManyToAny(fetch=FetchType.LAZY)
    @JoinTable
    (
        name="matricula", catalog="instituto", 
        
        joinColumns = 
        {   
            @JoinColumn(name="cod_alumno", nullable=false, updatable = false)   
        },
        inverseJoinColumns = 
        {
            @JoinColumn(name="cod_asig", nullable=false, updatable = false) 
        }
    )
    public Set<Asignatura> getAsignaturas()
    {
        return this.asignaturas;
    }
    public void setAsignaturas(Set<Asignatura> asignaturas)
    {
        this.asignaturas = asignaturas;
    }
}
