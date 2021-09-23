#include <iostream>

using namespace std;

// Prototipos
void suma(double n, double m, double &s);
void areayperimetro(double base, double altura, double &a, double &p);
void operacionFactorial(int num, int &res);
bool operaciones(double a, double b, double &suma, double &resta, double &multi, double &divi);

int main()
{
    double valor1, valor2, resultado, area, perimetro;
    int factorial, facres;
    cout << "Actividad 1.1: suma" << endl;
    cout << "Numero 1 : ";
    cin >> valor1;
    cout << "Numero 2 : ";
    cin >> valor2;
    suma(valor1, valor2, resultado);
    cout << "Suma con retorno : " << resultado << endl;

    cout << "Actividad 1.2: area y perimetro de un rectangulo" << endl;
    cout << "Base: ";
    cin >> valor1;
    cout << "Altura: ";
    cin >> valor2;
    areayperimetro(valor1, valor2, area, perimetro);
    cout << "Area del rectangulo: " << area << endl;
    cout << "Perimetro del rectangulo " << perimetro << endl;

    cout << "Actividad 1.3: factorial de un numero" << endl;
    cout << "Numero: ";
    cin >> factorial;
    operacionFactorial(factorial, facres);
    cout << "Factorial de " << factorial << " = " << facres << endl;




    return 0;
}

void suma(double n, double m, double &s)
{
    s = n + m;
}

void areayperimetro(double b, double a, double &ar, double &per)
{
    ar = b * a;
    per = (2 * b) + (2 * a);
}

void operacionFactorial(int num, int &res)
{
    int a = 1;
    for(int i = 1; i <= num; i++)
    {
        a *= i;
    }
    res = a;
}
