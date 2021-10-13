#include <iostream>
#include <cstring>
using namespace std;
string Codifica(string);
int main()
{
    string prin;
    string coded;
    cout << "Indica la cadena de caracteres que quieres codificar ";
    getline(cin, prin);
    coded = Codifica(prin);
    cout << "La cadena codificada es: " << coded << endl;
    return 0;
}
string Codifica(string prin)
{
    int tamArr = prin.length();
    char *cad = new char[tamArr];
    string coded;

    strcpy(cad, prin.c_str());

    for(int i = 0; i < tamArr; i++)
    {
        if((cad[i] > 47 && cad[i] < 55)||(cad[i] >= 65 && cad[i] < 87) || (cad[i] >= 97 && cad[i] < 119))
        {
            cad[i] += 3;
        } else if((cad[i] >= 55 && cad[i] <= 57))
        {
            cad[i] -= 7;
        } else if((cad[i] >= 87 && cad[i] <= 90) || (cad[i] >= 119 && cad[i] < 122))
        {
            cad[i] -= 23;
        }
    }
    coded = cad;
    return coded;
}
