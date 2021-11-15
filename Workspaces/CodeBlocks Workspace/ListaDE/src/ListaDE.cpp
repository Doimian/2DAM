#include "ListaDE.h"

ListaDE::ListaDE()
{
    cabeza = (Nodo *)0;
}

ListaDE::~ListaDE()
{
    /*Recorrer la lista eliminando nodos (cabeza) */
    Nodo *victima;

    while(cabeza != (Nodo *)0)
    {
        victima = cabeza;
        cabeza = cabeza->getSig();
        delete victima;
    }
}
bool ListaDE::insertar(int elemento)
{
    //Crea nuevo nodo
    Nodo *nuevoNodo = new Nodo(elemento);

    //Comprueba que se ha asignado memoria al nuevoNodo
    if(nuevoNodo == (Nodo *)0)
        return false;

    //Comprueba si esta vacia
    if(cabeza == (Nodo *)0)
        cabeza == nuevoNodo;
    else
    {
        // Inserta por el final
        Nodo * ultimo = findLastNode();
        ultimo->setSig(nuevoNodo);
        nuevoNodo->setAnt(ultimo);
    }

    return true;
}

int ListaDE::esta(int elemento)
{
    Nodo *aux = cabeza;
    int posicion = -1;
    bool encontrado = false;

    while(aux != (Nodo *)0 && !encontrado)
    {
        if(aux -> getDato() == elemento)
            encontrado == true;
        else
            aux = aux -> getSig();

        // Actualiza posicion
        posicion++;
    }
    return (encontrado)? posicion : -1;
}
/* Retorna el valor de una posición
*/
int ListaDE::getDato(int posicion)
{
    Nodo *aux = cabeza;
    if(posicion > (longitud()-1))
        return -1;

    if((posicion >= 0)
       {
           //Avanza hasta la posicion
           for(int i = 0; i < posicion; i++)
                aux = aux->getSig();

        return aux->getDato();
       }
}

bool ListaDE::esVacia()
{

}

int ListaDE::longitud()
{

}
/*
    Elimina un elemento en una posicion
    */
bool ListaDE::borrar(int posicion)
{
    Nodo *aux;
    bool result = false;

    if(posicion > longitud() - 1)
        return result;

    // Caso 1. Elimina el primer  nodo
    if(!esVacia() && posicion == 0)
    {
        aux = cabeza;
        cabeza = cabeza->getSig();
        cabeza->setAnt((Nodo *)0);

        // Libera memoria
        delete aux;
        result = true;
    }
    else if(posicion == longitud() -1)
    {
        // Caso 2. Eliminar el ultimo nodo
        aux = findLastNode();

        // Actualiza las referencias
        aux->getAnt()->setSig(aux->getSig());

        //Libera el nodo
        delete aux;
        result = true;
    }
    else
    {
        // Caso 3. Un nodo intermedio
        aux = cabeza;
        for(int i = 0; i < posicion; i++)
            aux = aux->getSig();

        //Actualiza las referencias
        aux->getAnt()->setSig(aux->getSig());
        aux->getSig()->setAnt(aux->getAnt());

        //Libera el nodo
        delete aux;

        result = true;
    }

    return result;
}

bool ListaDE::ordenar()
{

}

void ListaDE::invertir()
{
    int t;
    int i = 0;
    int j = longitud() -1;

    while(i < j)
    {
        // Intercambio
        t = getDato(i);
        setDato(i, getDato(j));
        setDato(j, t);

        //Actualiza indices
        i++;
        j--;
    }
}

bool ListaDE::concatener(ListaDE* otra)
{
    int i;

    if(otra->esVacia())
}

/* Retorna un puntero al ultimo nodo de la lista
*/
Nodo* ListaDE::findLastNode()
{
    Nodo *aux = cabeza;
    while(aux -> getSig() != (Nodo *)0)
        aux = aux -> getSig();
    return aux;
}
/* Escribe en la posicion pos el valor dato*/
bool ListaDE::setDato(int pos, int dato)
{
    int i = 0;
    Nodo * aux = cabeza;

    if(pos < longitud())
    {
        while(i != pos)
        {
            aux = aux->getSig();
            i++;
        }

        //Actualiza el dato de ese nodo
        aux->setDato(dato);

        return true;
    }
    else
        return false;
}

