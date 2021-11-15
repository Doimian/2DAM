#include <iostream>
#include "ListaDE.h"
using namespace std;

int main()
{
    ListaDE *lista = new ListaDE();

    // Inserta valores
    for(int i = 100; i < 120; i++)
        lista->insertar(i);

    //Muestra los valores de la lista
    for(int i = 0; i < lista->longitud(); i++)
        cout << "Elemento " << i <<" = " << lista->getDato(i) << endl;


    //Elimina
    delete lista;

    return 0;
}
