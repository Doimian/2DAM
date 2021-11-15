#ifndef COMPLEJO_H
#define COMPLEJO_H
#include<iostream>

using namespace std;

class Complejo
{
    public:
        Complejo operator+(Complejo c);
        Complejo operator-(Complejo c);
        bool operator==(Complejo c);
        Complejo(double, double);
        virtual ~Complejo();
        double getPR();
        double getPI();
        void toString();


    private:
        double parteImaginaria;
        double parteReal;
};

#endif // COMPLEJO_H
