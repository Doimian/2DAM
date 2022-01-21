
package t3_r1_ejercicio2;

/**
 *
 * @author Luis
 */
public class Jugadores {
    
    private String nombre;
    private String deporte;
    private String ciudad;
    private int edad;
    private Paises pais;
    
    //Constructores
    public Jugadores(){}
    
    public Jugadores(String nombre, String deporte, String ciudad, int edad, Paises pais){
        this.nombre = nombre;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.edad = edad;
        this.pais = pais;
    }
    
    //Metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

   
    
    
    
    @Override
    public String toString(){
        
        String cadena =  "Nombre:" + this.nombre + ", Deporte:" + this.deporte + ", Ciudad:" 
                    + this.ciudad + ", Edad:" + this.edad + " Datos Pais: " + this.pais.toString();
        
        return cadena;
    }
    
    
}
