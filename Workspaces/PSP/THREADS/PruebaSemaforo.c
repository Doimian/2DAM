#include <stdlib.h>
#include <pthread.h>
#include <stdio.h>
#include <string.h>
#include <semaphore.h>

#define NUM_ITE 10000

//Declaración de variables globales
sem_t semaforo;

void *incrementa(void *arg)
{
    //Declaración de variables
    int *argumento;
    int i;
    int j;

    //Inicio
    //Recuperamos los parámentros de entrada
    argumento = (int *) arg;
    //Incrementamos cada posición del array
    for(i = 0; i < 9; i++)
    {
        //Le sumamos 1 X iteraciones
        for(j = 0; j<NUM_ITE; j++)
        {
            sem_wait(&semaforo);
            argumento[i]++;
            sem_post(&semaforo);
        }
    }
    return NULL;
}
void *decrementa(void *arg)
{
    //Declaración de variables
    int *argumento;
    int i;
    int j;

    //Inicio
    //Recuperamos los parámentros de entrada
    argumento = (int *) arg;
    //Decrementamos cada posición del array
    for(i = 0; i < 9; i++)
    {
        //Le restamos 1 X iteraciones
        for(j = 0; j<NUM_ITE; j++)
        {
            sem_wait(&semaforo);
            argumento[i]--;
            sem_post(&semaforo);
        }
    }
    return NULL;
}

int main(void)
{
    //Declaración de variables
    pthread_t hilo1, hilo2;
    int datos[9] = {1, 1, 1, 1, 1, 1, 1, 1, 1};

    //Inicio
    //Inicializar el mutex
    if(sem_init(&semaforo, 0, 1) != 0)
    {
        printf("Error al crear el semaforo\n");
        return -3;
    }

    if(pthread_create(&hilo1, NULL, &incrementa, &datos) != 0)
    {
        printf("Error al crear el hilo 1");
        return -1;
    }
    if(pthread_create(&hilo2, NULL, &decrementa, &datos) != 0)
    {
        printf("Error al crear el hilo 2");
        return -2;
    }

    pthread_join(hilo1,NULL);
    pthread_join(hilo2,NULL);

    printf("Array final:\n%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t\n", datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], datos[8]);

    //Finalizamos el mutex
    sem_destroy(&semaforo);
    
    return 0;
}

