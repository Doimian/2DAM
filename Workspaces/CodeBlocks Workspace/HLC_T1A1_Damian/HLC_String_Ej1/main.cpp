#include <iostream>

using namespace std;

string SubCadena(string, int, int);

int main()
{
    string principal;
    int lon;
    int start;

    cout << "Indica la cadena de caracteres principal: ";
    getline(cin, principal);
    cout << "Indica la posicion de inicio de la subcadena:";
    cin >> start;
    cout << "Indica la longitud de la subcadena";
    cin >> lon;
    cout << "La sub-cadena resultante es " << SubCadena(principal, lon, start);

    return 0;
}

string SubCadena(string principal, int lon, int start)
{
    return principal.substr(start, lon);
}
