#ifndef LISTADE_H
#define LISTADE_H


class ListaDE
{
    private:
        Nodo *cabeza;
        Nodo *findLastNode();
        bool setDato(int pos, int dato);

    public:
        ListaDE();
        virtual ~ListaDE();

        // Interfaz del TAD Lista
        bool insertar(int elemento);
        int esta(int elemento);
        int getDato(int posicion);
        bool esVacia();
        int longitud();
        bool borrar(int elemento);
        bool ordenar();
        void invertir();
        bool concatener(ListaDE *otra);


};

#endif // LISTADE_H
