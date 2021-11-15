#include<iostream>
#include<cstring>
#include<string>
#include<ctime>
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
        Persona(string,string,string,string,string,string);
        virtual ~Persona();

        int edadActual();
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
