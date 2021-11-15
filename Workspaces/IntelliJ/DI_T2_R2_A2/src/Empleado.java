public class Empleado
{
    private int id_empleado;
    private String apellido;
    private int departamento;
    private Double salario;

    public Empleado()
    {
        id_empleado = 0;
        apellido = null;
        departamento = 0;
        salario = 0.0;
    }
    public Empleado(int id_empleado, String apellido, int departamento, Double salario)
    {
        this.id_empleado = id_empleado;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }
    public int getId_empleado()
    {
        return id_empleado;
    }

    public Double getSalario() {
        return salario;
    }

    public int getDepartamento() {
        return departamento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    @Override
    public String toString()
    {
        return String.format("ID: " + id_empleado + ",  APELLIDO: " + apellido + ",  DEP: " + departamento + ",  SALARIO: " + salario);
    }
}