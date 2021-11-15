#ifndef NODO_H
#define NODO_H


class Nodo
{
    private:
        int dato;
        Nodo *izq;
        Nodo *der;


    public:
        Nodo();
        virtual ~Nodo();

        // Metodos
        int getDato();
        void setDato(int);
        Nodo *getIzq();
        Nodo *getDer();
        void setIzq(Nodo *nodo);
        void setDer(Nodo *nodo);
        bool esHoja();

        //Recorridos
        void inorden(Nodo *nodo);
        void preorden(Nodo *nodo);
        void postorden(Nodo *nodo);

};

#endif // NODO_H
