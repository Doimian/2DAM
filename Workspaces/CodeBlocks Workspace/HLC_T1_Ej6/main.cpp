#include <iostream>
#include "Racional.h"
using namespace std;

int main()
{
    Racional fr1(2,3);
    Racional fr2(1,3);
    Racional fr3 = fr1.suma(fr2);
    Racional fr4 = fr1.resta(fr2);
    Racional fr5 = fr1.multiplicacion(fr2);
    Racional fr6 = fr1.division(fr2);
    cout << "Fraccion 1: "; fr1.toString();
    cout << endl << "Fraccion 2: "; fr2.toString();
    cout << endl << "Suma de las dos fracciones: "; fr3.toString();
    cout << endl << "Resta de las dor fracciones: "; fr4.toString();
    cout << endl << "Multiplicacion de las dos fracciones: "; fr5.toString();
    cout << endl << "Division de las dos fracciones: "; fr6.toString();
    cout << endl << "Fracciones en numeros reales " << fr1.toReal() << " " << fr2.toReal() << endl;
    return 0;
}
