#include <iostream>
#include "Complejo.h"

Complejo::Complejo(double a, double b)
{
    this->parteReal = a;
    this->parteImaginaria = b;
}

Complejo::~Complejo()
{
    //dtor
}

double Complejo::getPI()
{
    return parteImaginaria;
}
Complejo Complejo::operator+(Complejo c)
{
    this->parteReal += c.parteImaginaria;
    this->parteImaginaria += c.parteImaginaria;
}

Complejo Complejo::operator-(Complejo c)
{
    this->parteReal -= c.parteReal;
    this->parteImaginaria -= c.parteImaginaria;
}

bool Complejo::operator==(Complejo c)
{
    this->parteReal -= c.parteReal;
    this->parteImaginaria -= c.parteImaginaria;
    return (this->parteReal==c.parteReal && this->parteImaginaria==c.parteImaginaria)?true:false;
}


double Complejo::getPR()
{
    return parteReal;
}
void Complejo::toString()
{
    std::cout << "(" << getPR() << "," << getPI() << ")";
}
