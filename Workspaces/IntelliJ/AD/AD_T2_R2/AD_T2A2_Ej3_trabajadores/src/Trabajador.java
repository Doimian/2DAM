import java.io.Serializable;
import java.util.Date;

public class Trabajador implements Serializable
{
    private  String dni;
    private  String nombre;
    private  String telefono;
    private  String fecha_nacimiento;
    private  Double salario;

    public Trabajador()
    {
        dni = "";
        nombre="";
        telefono="";
        fecha_nacimiento=null;
        salario=0.0;
    }
    public Trabajador(String dni, String nombre, String telefono, String fecha_nacimiento, Double salario)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getSalario() {
        return salario;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    @Override
    public String toString()
    {
        return String.format("DNI : " + dni + "; Nombre : " + nombre + "; Telefono : " + telefono + "; Nacimiento : " + fecha_nacimiento + "; Salario : " + salario);
    }
}
