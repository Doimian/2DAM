#include <iostream>
#include "Persona.h"
using namespace std;

int main()
{
    Persona paco("paco","perez","21/05/1975","a","a","a");
    int edad_paco = paco.edadActual();
    cout << "La edad de paco es: " << edad_paco << endl;
    return 0;
}
