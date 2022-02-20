#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

#define NUM_VECES 100

sem_t sem1;
sem_t sem2;

void *escribePing(void *arg)
{
    
    int i;

    //Inicio
    for(i = 0; i < NUM_VECES; i++)
    {
        sem_wait(&sem1);
        printf("Ping ");
        sem_post(&sem2);
    }
    return NULL;
}

void *escribePong(void *arg)
{
    int i;
    //Inicio
    for (i = 0; i<NUM_VECES; i++)
    {
        sem_wait(&sem2);
        printf("Pong \n");
        sem_post(&sem1);
    }
    return NULL;
}


int main(void)
{

    //Declaración de variables
    pthread_t hilo1, hilo2;

    //Inicio
    //Utilizo semaforos
    sem_init(&sem1, 0, 1);
    sem_init(&sem2, 0,0);
    
    //Crear hilos
    pthread_create(&hilo1, NULL, &escribePing, NULL);
    pthread_create(&hilo2, NULL, &escribePong, NULL);

    pthread_join(hilo1, NULL);
    pthread_join(hilo2, NULL);

    return 0;
}
