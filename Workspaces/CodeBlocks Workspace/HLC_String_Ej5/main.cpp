#include <iostream>
#include <cstring>
using namespace std;
bool EsPalindromo(string,string);
int main()
{
    string cad;
    string dac;
    bool pal;

    cout << "Introduzca la primera original ";
    getline(cin, cad);
    cout << "Introduzca la segunda cadena ";
    getline(cin, dac);
    pal = EsPalindromo(cad,dac);
    if(pal == true)
        cout << "Las cadenas son palindromas" << endl;
    else
        cout << "Las cadenas no son palindromas" << endl;
    return 0;
}
bool EsPalindromo(string cad,string dac)
{
    int cadlen = cad.length();
    if(cad.length() != dac.length())
        return false;

    char *arcad = new char[cadlen];
    char *dacra = new char[cadlen];
    strcpy(arcad, cad.c_str());
    strcpy(dacra, dac.c_str());
    for(int i = 0; i < cadlen; i++)
    {
        if(cad[i] != dac[(cadlen - 1) - i])
            return false;
    }
    return true;
}
