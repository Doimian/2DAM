#ifndef CUENTAAHORRO_H
#define CUENTAAHORRO_H


class CuentaAhorro
{
    private:
        float TasaInteresAnual;
        float Saldo;

    public:
        CuentaAhorro(float,float);
        virtual ~CuentaAhorro();

        float UltimoInteresMensual();
        void ModificarTasaInteres(float);
        float getTasaInteresAnual();
        float getSaldo();

};

#endif // CUENTAAHORRO_H
