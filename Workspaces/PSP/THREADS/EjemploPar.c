#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <string.h>

void *cuadrado(void *arg)
{
    //Declaración de variables
    int numero;
    int *resultado;

    //Inicio
    numero = * ((int *) arg);
    numero *= numero;
    resultado = malloc(sizeof(int));
    *resultado = numero;

    pthread_exit((void *) resultado);
}

int main(void)
{
    //Declaración de variables
    pthread_t hilo1, hilo2;
    int numero[2];
    int *resultado[2];
    int error;

    //Inicio
    numero[0] = 100;
    numero[1] = 4;
    error = pthread_create(&hilo1, NULL, &cuadrado, &numero[0]);
    if(error != 0)
    {
        fprintf(stderr, "Se ha producido el error %d, %s\n", error, strerror(error));
        return -1;
    }
    error = pthread_create(&hilo2, NULL, &cuadrado, &numero[1]);
    if(error != 0)
    {
        fprintf(stderr, "Se ha producido el error %d, %s\n", error, strerror(error));
        return -2;
    }
    pthread_join(hilo1, (void **) &resultado[0]);
    pthread_join(hilo2, (void **) &resultado[1]);

    //Imprimimos los resultados
    printf("El cuadrado del numero %d es: %d\n", numero[0], *resultado[0]);
    printf("El cuadrado del numero %d es: %d\n", numero[1], *resultado[1]);

    //Liberamos la memoria
    free(resultado[0]);
    free(resultado[1]);

    return 0;
}
