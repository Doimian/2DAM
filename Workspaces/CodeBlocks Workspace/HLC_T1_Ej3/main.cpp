#include <iostream>

using namespace std;

void suma(int a, int b, int &c);
void suma(double a, double b, double &c);
void suma(char a, char b, char &c);

void areaRec(int a, int b, int &c);
void areaRec(double a, double b, double &c);

int main()
{
    int n1int, n2int, resultadoint = 0;
    double n1double, n2double, resultadodouble = 0;
    char n1char, n2char, resultadochar = 0;
    cout << "Tema 1 Ejercicio 3; Sobrecarga de funciones" << endl << endl;

    //SUMA
    cout << "Actividad 3.1: Suma de funciones con numeros enteros, reales o char" << endl;

        //int
    cout << "Suma de los numeros enteros 7 y 8" << endl;
    n1int = 7;
    n2int = 8;
    suma(n1int, n2int, resultadoint);
    cout << "Resultado de la suma: " << n1int << " + " << n2int << " = " << resultadoint <<endl << endl;

        //double
    cout << "Suma de los numeros reales 7.45 y 8.994" << endl;
    n1double = 7.45;
    n2double = 8.994;
    suma(n1double, n2double, resultadodouble);
    cout << "Resultado de la suma: " << n1double << " + " << n2double << " = " << resultadodouble <<endl << endl;

        //char
    cout << "Suma de los numeros char a y b" << endl;
    n1char = 'a';
    n2char = 'b';
    suma(n1char, n2char, resultadochar);
    cout << "Resultado de la suma: " << n1char << " (" <<(int)n1char <<" ) "<< " + " << n2char << " (" <<(int)n2char <<" )  = " << resultadochar << " (" << (int)resultadochar << ")" <<endl << endl;
/*
    //AREA
    cout << "Actividad 3.2: Calcular en area de un rectangulo con numeros enteros o reales" << endl;
    cout << "Numero 1: ";
    cin >> n1;
    cout << "Numero 2: ";
    cin >> n2;
    areaRec(n1, n2, resultado);
    cout << "El area del rectangulo es: " << n1 << " * " << n2 << " = " << resultado <<endl << endl;
    return 0; */
}

void suma(int a, int b, int &c)
{
    c = a + b;
}
void suma(double a, double b, double &c)
{
    c = a + b;
}
void suma(char a, char b, char &c)
{
    c = a + b;

}

void areaRec(int a, int b, int &c)
{
    c = a * b;
}
void areaRec(double a, double b, double &c)
{
    c = a * b;
}
