#include <stdio.h>
#include <pthread.h>

/*
 * ¿Qué ocurre si el hilo principal no espera la finalización de los hilos creados? 
 * Entonces los hilos serían destruidos cuando el hilo principal finalice, 
 * y eso depende completamente de cómo lo gestione el gestor de procesos
 *
 * ¿El programa tendría el mismo comportamiento? 
 * Si el hilo principal no espera a los secundarios, el programa sólo funcionaría si 
 * el gestor de procesos pone la ejecución de los hilos.
 *
 * ¿Qué modificaciones serían necesarias realizar en caso afirmativo?
 * Habría que modificar los atributos de los hilos para hacerlos independientes, 
 * o también se puede hacer que el hilo principal espere a que los hilos 
 * terminen (Esto es lo que he echo en éste programa)
 */

void *mensajes_impares(void *arg)
{
    //Declaración de variables
    int i;
    
    //Inicio
    for(i = 1; i < 100; i+=2)
    {
        printf("Numeros impares; %d\n",  i);
    }
    return NULL;
}

void *mensajes_pares(void *arg)
{
    //Declaración de variables
    int i;
    
    //Inicio
    for(i = 2; i < 100; i+=2)
    {
        printf("Numeros   pares; %d\n",  i);
    }
    return NULL;
}

int main()
{
    //Declaración de variables
    pthread_t hilo1;
    pthread_t hilo2;
    int i;

    //Inicio
    //Creación de los hilos
    pthread_create(&hilo1, NULL, &mensajes_impares, NULL);
    pthread_create(&hilo2, NULL, &mensajes_pares, NULL);

    pthread_join(hilo1, NULL);
    pthread_join(hilo2, NULL);

    return 0;
}
