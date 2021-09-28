#ifndef HOLA_H
#define HOLA_H

#include <iostream>
using namespace std;

class Hola
{
    private:
        int x;
        int y;

    public:
        Hola();
        Hola(int x, int y);
        ~Hola();
        int getX();
        int getY();
};

#endif // HOLA_H
