#include <iostream>
#include "CuentaAhorro.h"
using namespace std;

int main()
{
    CuentaAhorro ahorrador1(2000,3);
    CuentaAhorro ahorrador2(3500,3);

    cout << "El ahorrador 1 tiene un saldo de: " << ahorrador1.getSaldo() << "€, y una tasa de interes anual de: " << ahorrador1.getTasaInteresAnual() << "%" << endl;
    cout << "El ahorrador 2 tiene un saldo de: " << ahorrador2.getSaldo() << "€, y una tasa de interes anual de: " << ahorrador2.getTasaInteresAnual() << "%" << endl << endl;

    cout << "El interes mensual del ahorrador 1 es actualmente de " << ahorrador1.UltimoInteresMensual() << "€" << endl;
    cout << "El interes mensual del ahorrador 2 es actualmente de " << ahorrador2.UltimoInteresMensual() << "€" << endl << endl;

    cout << "Si ahora modificamos la tasa de interes anual de los ahorradores al 4%..." << endl << endl;

    ahorrador1.ModificarTasaInteres(4);
    ahorrador2.ModificarTasaInteres(4);
    cout << "El interes mensual del ahorrador 1 es actualmente de " << ahorrador1.UltimoInteresMensual() << "€" << endl;
    cout << "El interes mensual del ahorrador 2 es actualmente de " << ahorrador2.UltimoInteresMensual() << "€" << endl;
    return 0;
}
