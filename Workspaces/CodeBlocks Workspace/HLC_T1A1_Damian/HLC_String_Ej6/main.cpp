#include <iostream>
#include <cstring>
using namespace std;
string palindromea(string);
int main()
{
    string cad;
    string dac;
    cout << "Introduzca una cadena de texto ";
    getline(cin, cad);
    dac = palindromea(cad);
    cout << "El palindromo de esta cadena es: " << dac << endl;
    return 0;
}
string palindromea(string cad)
{
    int cadlen = cad.length();
    string dac;
    char *arcad = new char[cadlen];
    char *dacra = new char[cadlen];
    strcpy(arcad, cad.c_str());
    for(int i = 0; i < cadlen; i++)
    {
        dacra[i] = arcad[(cadlen - 1) - i];
    }
    return dac = dacra;
}
