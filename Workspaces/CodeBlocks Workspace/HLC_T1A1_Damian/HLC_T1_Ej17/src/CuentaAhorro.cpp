#include "CuentaAhorro.h"

CuentaAhorro::CuentaAhorro(float Saldo, float TasaInteresAnual)
{
    this->Saldo = Saldo;
    this->TasaInteresAnual = TasaInteresAnual;
}
float CuentaAhorro::UltimoInteresMensual()
{
    return (((TasaInteresAnual / 100) * Saldo) / 12);
}

void CuentaAhorro::ModificarTasaInteres(float nTasa)
{
    this->TasaInteresAnual = nTasa;
}

float CuentaAhorro::getTasaInteresAnual()
{
    return TasaInteresAnual;
}

float CuentaAhorro::getSaldo()
{
    return Saldo;
}

CuentaAhorro::~CuentaAhorro()
{
    //dtor
}
