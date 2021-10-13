#include<iostream>
using namespace std;

class Persona
{
    private:
        string nombre;
        string apellidos;
        string fechaNacimiento;
        string domicilio;
        string telefono;
        string estudios;

    public:
        Persona(string,string);
        Persona(string,string,string);
        Persona(string,string,string,string);
        Persona(string,string,string,string,string);
        Persona(string,string,string,string,string,string);
        virtual ~Persona();

        int edadActual(string);
        void imprimir();
        bool comparar(Persona);

        string getNombre();
        string getApellidos();
        string getFechaNacimiento();
        string getDomicilio();
        string getTelefono();
        string getEstudios();
        void setFechaNacimiento(string);
        void setDomicilio(string);
        void setTelefono(string);
        void setEstudios(string);
};
