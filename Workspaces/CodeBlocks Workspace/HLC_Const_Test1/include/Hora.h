#ifndef HORA_H
#define HORA_H
#include <iostream>
using namespace std;
class Hora
{
    private:
        int hora, minuto, segundo;
        const int anno;
        const Fecha FechaNacimiento;

    public:
        Hora(int hora = 0, int minuto = 0, int segundo = 0, int year = 0);
        virtual ~Hora();
        //Sets
        void SetHora(int h);
        void SetMinutos(int m);
        void SetSegundos(int s);

        //Gets
        int GetHora() const;
        int GetMinutos() const;
        int GetSegundos() const;

        //Imprime hora
        void Print();
};

#endif // HORA_H
