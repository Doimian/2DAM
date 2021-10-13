#include "Persona.h"

Persona::Persona(string nombre, string apellidos)
{
    nombre = nombre;
    apellidos = apellidos;
    fechaNacimiento = "";
    domicilio = "";
    telefono = "";
    estudios = "";
}
Persona::Persona(string nombre,string apellidos,string fechaNacimiento)
{
    nombre = nombre;
    apellidos = apellidos;
    fechaNacimiento = fechaNacimiento;
    domicilio = "";
    telefono = "";
    estudios = "";
}
Persona::Persona(string nombre,string apellidos,string fechaNacimiento,string domicilio)
{
    nombre = nombre;
    apellidos = apellidos;
    fechaNacimiento = fechaNacimiento;
    domicilio = domicilio;
    telefono = "";
    estudios = "";
}
Persona::Persona(string nombre,string apellidos,string fechaNacimiento,string domicilio, string telefono)
{
    nombre = nombre;
    apellidos = apellidos;
    fechaNacimiento = fechaNacimiento;
    domicilio = domicilio;
    telefono = telefono;
    estudios = "";
}
Persona::Persona(string nombre,string apellidos,string fechaNacimiento,string domicilio, string telefono,string estudios)
{
    nombre = nombre;
    apellidos = apellidos;
    fechaNacimiento = fechaNacimiento;
    domicilio = domicilio;
    telefono = telefono;
    estudios = estudios;
}

int Persona::edadActual(string fechaNacimiento)
{
    int annoNacimiento;
    int mesNacimiento;
    int diaNacimiento;
    int edActual;

    strcpy();

    return edActual;
}
void Persona::imprimir()
{
    cout << "Nombre : " << this->nombre; << endl;
    cout << "Apellidos : " << this->apellidos; << endl;
    if(this->fechaNacimiento != "")
        cout << "Fecha de Nacimiento : " << this->fechaNacimiento; << endl;
    else
        cout << "No se ha registrado una fecha de nacimiento para " << this->nombre << endl;
    if(this->domicilio != "")
        cout << "Domicilio : " << this->domicilio; << endl;
    else
        cout << "No se ha registrado un telefono para " << this->nombre << endl;
    if(this->telefono != "")
        cout << "Telefono : " << this->telefono; << endl;
    else
        cout << "No se han registrado estudios para " << this->nombre << endl;
    if(this->estudios!= "")
        cout << "Estudios : " << this->estudios; << endl;
    else
        cout << "No se han registrado estudios para " << this->nombre << endl;
}
bool Persona::comparar(Persona otraPersona)
{
    bool iguales = true;
    if(this->nombre != otraPersona->nombre)
        iguales = false;
    if(this->apellidos != otraPersona->apellidos)
        iguales = false;
    if(this->fechaNacimiento != otraPersona->fechaNacimiento)
        iguales = false;
    if(this->domicilio != otraPersona->domicilio)
        iguales = false;
    if(this->telefono != otraPersona->telefono)
        iguales = false;
    if(this->estudios != otraPersona->estudios)
        iguales = false;
    return iguales;
}

string Persona::getNombre()
{
    return nombre;
}
string Persona::getApellidos()
{
    return apellidos;
}
string Persona::getFechaNacimiento()
{
    return fechaNacimiento;
}
string Persona::getDomicilio()
{
    return domicilio;
}
string Persona::getTelefono()
{
    return telefono;
}
string Persona::getEstudios()
{
    return estudios;
}
void Persona::setFechaNacimiento(string s)
{
    fechaNacimiento = s;
}
void Persona::setDomicilio(string s)
{

}
void Persona::setTelefono(string s)
{

}
void Persona::setEstudios(string s)
{

}

Persona::~Persona()
{
    //dtor
}
