#include <iostream>
#include "hola.h"

using namespace std;

int main()
{
    cout << "Clases en C++" << endl;

    //Formas de instanciaci�n de clases
    Hola r1;
    Hola r2(10,11);
    Hola *r3 = new Hola();

    //llamada a m�todos
    r1.getX();
    r3->getX();

    //elimina el objeto -> llama al destructor
    delete r3;

    return 0;
}
