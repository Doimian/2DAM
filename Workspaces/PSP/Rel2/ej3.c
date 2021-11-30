/*
 * Damian
 * PSP 1.2.3
 * Manejar señal CTRL+C (SIGINT)
 * */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>

/* Prototipo del sigint handler*/
void sigint_handler(int sig);
int main(void)
{
    /*Declaramos el handler de la signal*/
    signal(SIGINT, sigint_handler);

    /*Esperamos*/
    printf("Esperando que se presione Ctrl+c para ir a dormir...\n");

    while(1)
    {
        pause();
    }
    return 0;
}
void sigint_handler(int sig)
{
    printf("Se ha presionado Ctrl+c\nMe voy a dormir...\n");
    exit(0);
}
