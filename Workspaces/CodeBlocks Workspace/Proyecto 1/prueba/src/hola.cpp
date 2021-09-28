#include "hola.h"
#include <iostream>

Hola::Hola()
{
    x = 0;
    y = 0;
    cout << "Constructor por defecto" << endl;
}
Hola::Hola(int x, int y)
{
    this->x = x;
    this->y = y;
    cout << "Constructor alternativo" << endl;
}

Hola::~Hola()
{
    cout << "Destructor por Defecto" << endl;
}

int Hola::getX()
{
    return x;
}

int Hola::getY()
{
    return y;
}
