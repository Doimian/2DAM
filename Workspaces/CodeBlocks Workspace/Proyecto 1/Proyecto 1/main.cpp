#include <iostream>

using namespace std;

// Prototipos
void suma(double n, double m, double &s);
void areayperimetro(double base, double altura, double &a, double &p);
void operacionFactorial(int num, int &res);
bool operaciones(double a, double b, double &suma, double &resta, double &multi, double &divi);
void isPar(int n);
void isPrimo(int n);
int main()
{
    double valor1, valor2, resultado, area, perimetro;
    double suma, resta, multi, divi;
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

    cout << "Actividad 1.4: comprobar si un numero es par" << endl;
    cout << "Numero: ";
    cin >> valor1;
    isPar(valor1);

    cout << "Actividad 1.5: comprobar si un numero es primo" << endl;
    cout << "Numero: ";
    cin >> valor1;
    isPrimo(valor1);

    cout << "Actividad 1.6: hacer la suma, resta, multiplicación y división de dos números indicando si hay un error" << endl;
    cout << "Numero 1: ";
    cin >> valor1;
    cout << "Numero 2: ";
    cin >> valor2;
    bool comprobacion = operaciones(valor1, valor2, suma, resta, multi, divi);
    if (comprobacion == true)
    {
        cout << "La suma de " << valor1 << " y " << valor2 << " = " << suma;
    }

    return 0;
}

bool operaciones(double a, double b, double &suma, double &resta, double &multi, double &divi)
{
    if(a != 0 && b != 0)
    {
        suma = a + b;
        resta = a - b;
        multi = a * b;
        divi = a / b;
        return true;
    }
    suma = a + b;
    resta = a - b;
    multi = 0;
    divi = -1;
    return false;
}

void isPrimo(int n)
{
    bool esPrimo = true;
    if(n < 3)
        esPrimo = false;

    for(int i = 2; i < n; i++)
    {
        if(n % i == 0)
            esPrimo = false;
    }
    if(esPrimo == true)
        cout << "El numero " << n << " es primo" << endl;
    else
        cout << "El numero " << n << " no es primo" << endl;
}

void isPar(int n)
{
    if(n % 2 == 0)
        cout << "El numero " << n << " es par" << endl;
    else
        cout << "El numero " << n << " es impar" << endl;
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
