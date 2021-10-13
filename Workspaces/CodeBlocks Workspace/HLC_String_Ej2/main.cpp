#include <iostream>

using namespace std;

string BorraCaracterDeCadena(string,char);

int main()
{
    string principal;
    char caracter;
    cout << "Escribe la cadena inicial de caracteres:";
    getline(cin,principal);
    cout << "Ahora escribe el caracter que quieres que se elimine de la cadena:";
    cin >> caracter;
    cout << "La cadena resultante es " << BorraCaracterDeCadena(principal, caracter);


    return 0;
}

string BorraCaracterDeCadena(string p, char c)
{
    while(p.find(c, 0) != string::npos)
    {
        p.replace(p.find(c),1,"");
    }
      return p;
}
