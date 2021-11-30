/*
 * Damian
 * PSP 1.2.5
 * Manejar señal CTRL+C (SIGINT) e ignorar el resto
 * */

#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

void sigint_handler(int sig);
int main(void)
{
    /*Indicamos el manejador de la señal*/
    signal(SIGINT, sigint_handler);
    
    while(1)
    {
        /*Esperamos*/
        printf("Esperando que se presione Ctrl+c para ir a dormir...\n");
        pause();
    }
    return 0;
}

void sigint_handler(int sig)
{
    signal(sig, SIG_IGN);
    printf("\nPreparando la cama para dormir, dame 5 segundos\n");
    sleep(5);
    printf("\nYa he terminado! buenas noches\n");
    exit(0);
}
