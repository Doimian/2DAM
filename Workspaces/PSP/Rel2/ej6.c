/*
 * Damian
 * PSP 1.2.6
 * Manejar dos señales (SIGTERM - SIGUSR1)
 * */

#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

/*Manejadores*/
void sigterm_handler(int sig);
void sigusr1_handler(int sig);
int main(void)
{
    /*Asignar las señales a sus manejadores*/
    signal(SIGTERM, sigterm_handler);
    signal(SIGUSR1, sigusr1_handler);

    /*Semilla de tiempo aleatoria*/
    srand(time(NULL));

    /*Indicamos el pid del proceso*/
    printf("Hola soy un proceso con PID %d!\n", getpid());
   while(1) 
       pause();
    return 0;
}
void sigterm_handler(int sig)
{
    /*Cuando se le envía esta señal el programa debe terminar*/
    printf("El PID con proceso %d se despide\n", getpid());
    exit(0);
}
void sigusr1_handler(int sig)
{
    /*Imprimir un número aleatorio en pantalla*/
    printf("Tengo tanta hambre que me comería %d hamburguesas\n", rand());
}
