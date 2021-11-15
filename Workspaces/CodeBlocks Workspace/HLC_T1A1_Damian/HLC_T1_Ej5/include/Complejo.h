#ifndef COMPLEJO_H
#define COMPLEJO_H


class Complejo
{
    public:
        Complejo(double, double);
        virtual ~Complejo();
        double getPR();
        double getPI();
        Complejo suma(Complejo);
        Complejo resta(Complejo);
        void toString();


    private:
        double parteImaginaria;
        double parteReal;
};

#endif // COMPLEJO_H
