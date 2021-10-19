#include "Hora.h"

Hora::Hora(int hora, int minuto, int segundo,int year, Fecha fn) : anno(year), FechaNacimiento(fn)
{
    this->SetHora(hora);
    this->SetMinutos(minuto);
    this->SetSegundos(segundo);
}

Hora::~Hora()
{

}

void Hora::SetHora(int h)
{
    hora = h;
}

void Hora::SetMinutos(int m)
{
    minuto = m;
}

void Hora::SetSegundos(int s)
{
    segundo = s;
}

int Hora::GetHora() const
{
    return hora;
}

int Hora::GetMinutos() const
{
    return minuto;
}

int Hora::GetSegundos() const
{
    return segundo;
}

void Hora::Print()
{
    cout << hora << ":" << minuto << ":" << segundo;
}
