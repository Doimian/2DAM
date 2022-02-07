package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @Column(name = "codemple", length = 4, nullable = false, unique = true)
    private int codemple;

    @Column(name = "nombre", length = 15, nullable = true)
    private String nombre;

    @Column(name = "apellidos", length = 25, nullable = true)
    private String apellidos;

    @Column(name = "salario", length = 7, nullable = true)
    private double salario;

    @ManyToOne
    @JoinColumn(name = "dpto")
    private Departamento dpto;

    public Empleado()
    {

    }

    public Empleado( String Nombre, String Apellidos, Departamento Dpto)
    {
        this.nombre = Nombre;
        this.apellidos = Apellidos;
        this.dpto = Dpto;
    }

    

    public Empleado(int codemple, String nombre, String apellidos, double salario, Departamento dpto) {
        this.codemple = codemple;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
        this.dpto = dpto;
    }

    public int getCodemple() {
        return codemple;
    }

    public void setCodemple(int codemple) {
        this.codemple = codemple;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Departamento getDpto() {
        return dpto;
    }

    public void setDpto(Departamento dpto) {
        this.dpto = dpto;
    }

    public void setSalario(double salario)
    {
        this.salario = salario;
    }

    public double getSalario()
    {
        return salario;
    }
    
}
