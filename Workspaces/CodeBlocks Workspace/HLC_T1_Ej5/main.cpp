#include <iostream>
#include "Complejo.h"
using namespace std;
int main()
{
    Complejo com1(3.4,5.6);
    Complejo com2(4.5,6.7);
    cout << "com1 = " << com1.getPR() << "," << com1.getPI() << endl;
    cout << "com2 = " << com2.getPR() << "," << com2.getPI() << endl;
    Complejo com3 = com1.suma(com2);
    cout << "suma = " << com3.getPR() << "," << com3.getPI() << endl;
    Complejo com4 = com1.resta(com2);
    cout << "suma = " << com4.getPR() << "," << com4.getPI() << endl;
    cout << "impresion de los numeros complejos : ";
    com1.toString(); cout << " "; com2.toString(); cout << " "; com3.toString(); cout << " "; com4.toString(); cout << endl;
    return 0;
}
