#ifndef ARBOLBI_H
#define ARBOLBI_H


class ArbolBI
{
    private:
        Nodo *raiz;

    public:
        ArbolBI();
        virtual ~ArbolBI();

        bool insertar(Nodo *nodo);
        bool borrar(Nodo * nodo);
        Nodo *buscar(Nodo *n);
        int numeroNodos();

        //Recorridos
        void inorden(Nodo *nodo);
        void preorden(Nodo *nodo);
        void postorden(Nodo *nodo);
};

#endif // ARBOLBI_H
