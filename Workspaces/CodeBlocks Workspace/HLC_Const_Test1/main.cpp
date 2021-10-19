#include <iostream>
#include "Hora.h"
using namespace std;

int main()
{
    cout << "Ejemplo de uso const" << endl;

    //Define un objeto no constante
    Hora ensayo(18,30,0);

    // Define un objeto constante
    const Hora despertar(7,0,0) ;

    // Caso 1. Llamada de método NO CONSTANTE a un objeto NO CONSTANTE -> OK
    ensayo.SetHora(45);
    cout << "Hora ensayo: " << ensayo.GetHora() << endl;

    //Caso 2. Llamada de método NO CONSTANTE a un objeto CONSTANTE -> ERROR
    //despertar.GetHora();
    //despertar.SetHora(6);

    //Caso 3. Llamada de método CONSTANTE a un objeto NO CONSTANTE -> OK

    //Caso 4. Llamada de método CONSTANTE a un objeto CONSTANTE -> OK
    despertar.GetHora();

    return 0;
}
