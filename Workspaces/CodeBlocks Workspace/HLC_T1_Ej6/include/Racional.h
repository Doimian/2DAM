#ifndef RACIONAL_H
#define RACIONAL_H


class Racional
{
    public:
        Racional(int, int);
        virtual ~Racional();
        int getNum();
        int getDen();
        Racional suma(Racional);
        Racional resta(Racional);
        Racional multiplicacion(Racional);
        Racional division(Racional);
        double toReal();
        void toString();

    private:
        int numerador;
        int denominador;
};

#endif // RACIONAL_H
