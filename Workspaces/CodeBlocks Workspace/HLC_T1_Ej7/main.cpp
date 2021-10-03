#include <iostream>
#include "Rectangulo.h"
using namespace std;

int main()
{
    Rectangulo rec();
    int ancho;
    int longitud;

    cout << "Rectangulo uno creado, ancho: " << rec.getAn() << " longitud: " << rec.getLon() << endl;
    cout << "Modifica sus valores sin salirte de los limites (0-20)" << endl;
    cout << "Ancho : " << endl;
    cin >> ancho;
        rec.setAn(ancho);
    cout << "Longitud : " << endl;
    cin >> longitud;
        rec.setLon(longitud);
    cout << "Rectangulo con valores modificados, ancho: " << rec.getAn() << " longitud: " << rec.getLon() << endl;
    return 0;
}
