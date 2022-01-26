#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

//Struct que soporta los argumentos
struct arg
{
    char caracter;
    int repeticiones;
    int latencia;
};

//Función que van a hacer los threads
void *imprimir_numeros(void *arg)
{
    //Variables
    int i;
    struct arg args = *((struct arg *) arg);

    //Método que escribe el mensaje en bucle
    for(i = 1; i <= args.repeticiones; i++)
    {
        printf("Mensaje %d de %d, la letra es %c\n", i, args.repeticiones, args.caracter);
        sleep(args.latencia);
    }
    return NULL;
}

//Main
int main(void)
{
    //Variables
    //Argumentos para las threads
    struct arg var_thread1 = {'A', 30, 1};
    struct arg var_thread2 = {'B', 20, 2};
    struct arg var_thread3 = {'C', 10, 3};
    //Ids de las threads
    pthread_t thread1;
    pthread_t thread2;
    pthread_t thread3;

    //lanzamos los threads
    pthread_create(&thread1, NULL, &imprimir_numeros, &var_thread1);
    pthread_create(&thread2, NULL, &imprimir_numeros, &var_thread2);
    pthread_create(&thread3, NULL, &imprimir_numeros, &var_thread3);

    //Esperamos a que terminen las threads para finalizar
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);
    pthread_join(thread3, NULL);
    

    return 0;
}
