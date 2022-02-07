package entities;


import java.util.Set;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @Column(length = 11, nullable = false, unique = true)
    private int codept;

    @Column(length = 50, nullable = true)
    private String nombre;

    @OneToMany(mappedBy = "dpto", cascade = CascadeType.ALL)
    private List<Empleado> empleados;

    public Departamento() {
    }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Departamento(int Codept, String nombre) {
        this.codept= Codept;
        this.nombre = nombre;
    }

    public int getCodept() {
        return codept;
    }

    public void setCodept(int codept) {
        this.codept = codept;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empSet)
    {
        this.empleados = empSet;
    }

    
}
