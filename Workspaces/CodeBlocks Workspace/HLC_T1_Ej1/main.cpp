#include <iostream>

using namespace std;

// Prototipos
void suma(double n, double m, double &s);
void areayperimetro(double base, double altura, double &a, double &p);
void operacionFactorial(int num, int &res);
bool operaciones(double a, double b, double &suma, double &resta, double &multi, double &divi);
void isPar(int n, bool &r);
void isPrimo(int n, bool &r);

int main()
{
    double valor1, valor2, resultado, area, perimetro;
    double sumaa, resta, multi, divi;
    bool res;
    int factorial, facres;
    cout << "Actividad 1.1: suma" << endl;
    cout << "Numero 1 : ";
    cin >> valor1;
    cout << "Numero 2 : ";
    cin >> valor2;
    suma(valor1, valor2, resultado);
    cout << "Suma con retorno : " << resultado << endl << endl;

    cout << "Actividad 1.2: area y perimetro de un rectangulo" << endl;
    cout << "Base: ";
    cin >> valor1;
    cout << "Altura: ";
    cin >> valor2;
    areayperimetro(valor1, valor2, area, perimetro);
    cout << "Area del rectangulo: " << area << endl;
    cout << "Perimetro del rectangulo " << perimetro << endl << endl;

    cout << "Actividad 1.3: factorial de un numero" << endl;
    cout << "Numero: ";
    cin >> factorial;
    operacionFactorial(factorial, facres);
    cout << "Factorial de " << factorial << " = " << facres << endl << endl;

    cout << "Actividad 1.4: comprobar si un numero es par" << endl;
    cout << "Numero: ";
    cin >> valor1;
    isPar(valor1, res);
    if(res == true)
        cout << "El numero " << valor1 << " es par" << endl << endl;
    else if(res == false)
        cout << "El numero " << valor1 << " es impar" << endl << endl;

    cout << "Actividad 1.5: comprobar si un numero es primo" << endl;
    cout << "Numero: ";
    cin >> valor1;
    isPrimo(valor1, res);
    if(res == true)
        cout << "El numero " << valor1 << " es primo" << endl << endl;
    else if(res == false)
        cout << "El numero " << valor1 << " no es primo" << endl << endl;

    cout << "Actividad 1.6: hacer la suma, resta, multiplicación y división de dos numeros indicando si hay un error" << endl;
    cout << "Numero 1: ";
    cin >> valor1;
    cout << "Numero 2: ";
    cin >> valor2;
    bool comprobacion = operaciones(valor1, valor2, sumaa, resta, multi, divi);
    if (comprobacion == true)
    {
        cout << "Suma: " << valor1 << " + " << valor2 << " = " << sumaa << endl;
        cout << "Resta: " << valor1 << " - " << valor2 << " = " << resta << endl;
        cout << "Multiplicacion: " << valor1 << " * " << valor2 << " = " << multi << endl;
        cout << "Division: " << valor1 << " / " << valor2 << " = " << divi << endl;
    }
    else if (comprobacion == false)
    {
        cout << "Suma: " << valor1 << " + " << valor2 << " = " << sumaa << endl;
        cout << "Resta: " << valor1 << " - " << valor2 << " = " << resta << endl;
        cout << "Multiplicacion: " << valor1 << " * " << valor2 << " = " << multi << endl;
        cout << "La division de '" << valor1 << " / " << valor2 << "' no se puede hacer" << endl;
    }

    return 0;
}

bool operaciones(double a, double b, double &suma, double &resta, double &multi, double &divi)
{
    if(b != 0)
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
    divi = 0;
    return false;
}

void isPrimo(int n, bool &r)
{
    r = true;
    if(n > 1 && n < 3)
        r = false;
    for(int i = 2; i < n; i++)
    {
        if(n % i == 0)
            r = false;
    }
}

void isPar(int n, bool &r)
{
    if(n % 2 == 0)
        r = true;
    else
        r = false;
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
