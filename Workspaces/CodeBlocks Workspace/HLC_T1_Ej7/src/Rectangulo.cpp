#include "Rectangulo.h"
#include <iostream>
#define MIN_VAL 0
#define MAX_VAL 20
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
            std::cout << "Valor modificado" << endl;
        }
    else
        std::cout << "Valor no aceptado" << endl;
    return;
}
void Rectangulo::setLon(int a)
{
    if(a <= MAX_VAL && a > MIN_VAL)
        {
            longitud = a;
            std::cout << "Valor modificado" << endl;
        }
    else
        std::cout << "Valor no aceptado";
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
