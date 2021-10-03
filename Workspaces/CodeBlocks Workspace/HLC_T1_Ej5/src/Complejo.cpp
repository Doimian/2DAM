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

double Complejo::getPR()
{
    return parteReal;
}
Complejo Complejo::suma(Complejo c)
{
    return Complejo(c.getPR() + getPR(), c.getPI() + getPI());
}
Complejo Complejo::resta(Complejo c)
{
    return Complejo(c.getPR() - getPR(), c.getPI() - getPI());
}
double toReal()
{
    return(getNum() / getDen());
}
void Complejo::toString()
{
    std::cout << "(" << getPR() << "," << getPI() << ")";
}
