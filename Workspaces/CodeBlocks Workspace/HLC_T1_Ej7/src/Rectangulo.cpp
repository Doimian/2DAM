#include "Rectangulo.h"

Rectangulo::Rectangulo()
{
    longitud = 1;
    ancho = 1;
}

Rectangulo::~Rectangulo()
{
    //dtor
}

void Rectangulo::setAn(int a)
{
    if(a <= MAX_VAL && a > MIN_VAL)
        {
            ancho = a;
            cout << "Valor modificado" << endl;
        }
    else
        cout << "Valor no aceptado" << endl;
    return;
}
void Rectangulo::setLon(int a)
{
    if(a <= MAX_VAL && a > MIN_VAL)
        {
            longitud = a;
            cout << "Valor modificado" << endl;
        }
    else
        cout << "Valor no aceptado";
    return;
}
int Rectangulo::getAn()
{
    return ancho;
}
int Rectangulo::getLon()
{
    return longitud;
}
