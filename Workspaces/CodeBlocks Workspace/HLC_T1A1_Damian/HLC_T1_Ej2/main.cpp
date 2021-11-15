#include <iostream>

using namespace std;

// Prototipos
double suma(double n, double m);
double areaRec(double base, double altura);
double perimetroRec(double base, double altura);
int operacionFactorial(int num);
bool operaciones(double a, double b, double &suma, double &resta, double &multi, double &divi);
bool isPar(int n);
bool isPrimo(int n);

int main(void)
{
    double valor1, valor2, resultado, area, perimetro;
    double sumaa, resta, multi, divi;
    bool res;
    int factorial, facres;
    cout << "Actividad 1.1: suma" << endl;
    cout << "Numero 1 : ";
    cin >> valor1;
    cout << "Numero 2 : 0" << endl;
    valor2 = 0;
    resultado = suma(valor1, valor2);
    cout << "Suma con retorno : " << resultado << endl << endl;

    cout << "Actividad 1.2: area y perimetro de un rectangulo" << endl;
    cout << "Base: 10" << endl;
    valor1 = 10;
    cout << "Altura: ";
    cin >> valor2;
    area = areaRec(valor1, valor2);
    perimetro = perimetroRec(valor1, valor2);
    cout << "Area del rectangulo: " << area << endl;
    cout << "Perimetro del rectangulo " << perimetro << endl << endl;

    cout << "Actividad 1.3: factorial de un numero" << endl;
    cout << "Numero: 5" << endl;
    factorial = 5;
    facres = operacionFactorial(factorial);
    cout << "Factorial de " << factorial << " = " << facres << endl << endl;

    cout << "Actividad 1.4: comprobar si un numero es par" << endl;
    cout << "Numero: 2" << endl;
    valor1 = 2;
    res = isPar(valor1);
    if(res == true)
        cout << "El numero " << valor1 << " es par" << endl << endl;
    else if(res == false)
        cout << "El numero " << valor1 << " es impar" << endl << endl;

    cout << "Actividad 1.5: comprobar si un numero es primo" << endl;
    cout << "Numero: 7" << endl;
    valor1 = 7;
    res = isPrimo(valor1);
    if(res == true)
        cout << "El numero " << valor1 << " es primo" << endl << endl;
    else if(res == false)
        cout << "El numero " << valor1 << " no es primo" << endl << endl;

    cout << "Actividad 1.6: hacer la suma, resta, multiplicación y división de dos numeros indicando si hay un error" << endl;
    cout << "Numero 1: 1" << endl;
    valor1 = 1;
    cout << "Numero 2: 1" << endl;
    valor2 = 1;
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

bool isPrimo(int n)
{
    if(n == 1)
        return(true);
    if(n > 1 && n < 3)
        return(false);
    for(int i = 2; i < n; i++)
    {
        if(n % i == 0)
            return(false);
    }
}

bool isPar(int n)
{
    if(n % 2 == 0)
        return(true);
    else
        return(false);
}

double suma(double n, double m)
{
    return(n + m);
}

double areaRec(double b, double a)
{
    return (b * a);
}
double perimetroRec(double b, double a)
{
    return ((2 * b) + (2 * a));
}

int operacionFactorial(int num)
{
    int a = 1;
    for(int i = 1; i <= num; i++)
    {
        a *= i;
    }
     return a;
}
