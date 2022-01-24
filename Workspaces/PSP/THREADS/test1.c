#include <stdio.h>
#include <pthread.h>


//Declaración de estructura
struct argumentos
{
    int veces; //Número de veces a imprimir
    char caracter; //Caracter a imprimir
};

//Finción thread
void *imprimir_mensaje(void *arg)
{
    //Declaración de variables
    int i;
    struct argumentos valor1;
    
    //Recuperamos el parámetro del hilo principal
    valor1 = *((struct argumentos  *) arg);
    
    //Inicio
    for(i = 0; i < valor1.veces; i++)
    {
        printf("Caracter a imprimir: %c\n",  valor1.caracter);
    }
    return NULL;
}

int main()
{
    //Declaración de variables
    pthread_t hilo1;
    int i;
    struct argumentos valor1 = {2, 'A'};

    //Inicio
    //Creación del hijo 1
    pthread_create(&hilo1, NULL, &imprimir_mensaje, &valor1);

    for(i=0; i<10; i++)
    {
        printf("Mensaje numero %d del hilo %lu (principal)\n", i, pthread_self());
    }

    pthread_join(hilo1, NULL);

    return 0;
}
