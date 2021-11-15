#include "Racional.h"
#include <iostream>
Racional::Racional(int num, int den)
{
    numerador = num;
    denominador = den;
}

Racional::~Racional()
{
    //dtor
}
int Racional::getDen()
{
    return denominador;
}
int Racional::getNum()
{
    return numerador;
}
Racional Racional::suma(Racional c)
{
    return Racional(c.getNum() * getDen() + c.getDen() * getNum(), c.getDen() * getDen());
}
Racional Racional::resta(Racional c)
{
    return Racional(getNum() * getDen() - c.getDen() * c.getNum(), c.getDen() * getDen());
}
Racional Racional::multiplicacion(Racional c)
{
    return Racional(c.getNum() * getNum(), c.getDen() * getDen());
}
Racional Racional::division(Racional c)
{
    return Racional(getNum() * c.getDen(), c.getNum() * getDen());
}
double Racional::toReal()
{
    return ((double)getNum() / (double)getDen());
}
void Racional::toString()
{
    std::cout << "(" << getNum() << "/" << getDen() << ")";
}
