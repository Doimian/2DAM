#include "Persona.h"
Persona::Persona(string nombre,string apellidos,string fechaNacimiento,string domicilio, string telefono,string estudios)
{
    this->nombre = nombre;
    this->apellidos = apellidos;
    this->fechaNacimiento = fechaNacimiento;
    this->domicilio = domicilio;
    this->telefono = telefono;
    this->estudios = estudios;
}

int Persona::edadActual()
{
    /*Primero averiguamos el dia y el año actuales*/
    time_t f = time(0);
    struct tm * fechaActual = localtime(&f);
    int annoActual = fechaActual->tm_year + 1900;
    int diaActual = fechaActual->tm_yday;

    /*Aislar el año y el dia de nacimiento -> formato de la fecha dia/mes/año*/
    int annoNac = stoi(fechaNacimiento.substr(6,4));
    int diaNac = stoi(fechaNacimiento.substr(0,2));
cout << "Anio nac: " << annoNac << " Dia nac: " << diaNac << endl;
    /*Hacemos las operaciones necesarias*/
    int edad = annoActual - annoNac;
    if(diaActual < diaNac)
        edad -1;

    return edad;
}
void Persona::imprimir()
{
    cout << "Nombre : " << this->nombre << endl;
    cout << "Apellidos : " << this->apellidos << endl;
    if(this->fechaNacimiento != "")
        cout << "Fecha de Nacimiento : " << this->fechaNacimiento << endl;
    else
        cout << "No se ha registrado una fecha de nacimiento para " << this->nombre << endl;
    if(this->domicilio != "")
        cout << "Domicilio : " << this->domicilio << endl;
    else
        cout << "No se ha registrado un telefono para " << this->nombre << endl;
    if(this->telefono != "")
        cout << "Telefono : " << this->telefono << endl;
    else
        cout << "No se han registrado estudios para " << this->nombre << endl;
    if(this->estudios!= "")
        cout << "Estudios : " << this->estudios << endl;
    else
        cout << "No se han registrado estudios para " << this->nombre << endl;
}
bool Persona::comparar(Persona otraPersona)
{
    bool iguales = true;
    if(this->nombre != otraPersona.nombre)
        iguales = false;
    if(this->apellidos != otraPersona.apellidos)
        iguales = false;
    if(this->fechaNacimiento != otraPersona.fechaNacimiento)
        iguales = false;
    if(this->domicilio != otraPersona.domicilio)
        iguales = false;
    if(this->telefono != otraPersona.telefono)
        iguales = false;
    if(this->estudios != otraPersona.estudios)
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
    this->domicilio = s;
}
void Persona::setTelefono(string s)
{
    telefono = s;
}
void Persona::setEstudios(string s)
{
    estudios = s;
}

Persona::~Persona()
{
    //dtor
}
