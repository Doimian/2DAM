/*
 * Damian
 * PSP 1.2.4
 * Manejar señal CTRL+C (SIGINT) varias veces
 * */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>

/* Prototipo del sigint handler*/
void sigint_handler(int sig);

int contador_sigint = 6;

int main(void)
{
    /*Declaramos el handler de la signal*/
    signal(SIGINT, sigint_handler);

    while(1)
    {
        /*Esperamos*/
        printf("\nEsperando que se presione Ctrl+c %d veces para ir a dormir...\n", contador_sigint);
        pause();
    }
    return 0;
}
void sigint_handler(int sig)
{
    if((contador_sigint-1) != 0)
    {
        contador_sigint--;
    }else
    {
        printf("\nSe ha presionado Ctrl+c 6 veces,\nMe voy a dormir...\n");
        exit(0);
    }
}
