#include <iostream>

using namespace std;
int BuscarSubCadena(string, string);
int main()
{
    string principal;
    string subs;
    int pos;
    cout << "Indica la cadena principal: " ;
    getline(cin,principal);
    cout << "Indica la subcadena: ";
    getline(cin,subs);
    pos = BuscarSubCadena(principal, subs);
    if(pos == -1)
        cout << "La subcadena no esta incluida en la cadena principal" << endl;
    else
    {
        cout << "La subcadena esta incluida en la posicion " << pos << " de la cadena principal" << endl;
    }


    return 0;
}
int BuscarSubCadena(string pri, string sub)
{
    if(pri.find(sub) == string::npos)
        return -1;
    else
    {
        return pri.find(sub);
    }
}
