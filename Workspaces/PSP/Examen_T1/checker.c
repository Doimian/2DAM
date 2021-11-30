/*
 * Examen Tema 1
 * checker
 * Proceso que se encarga de comprobar las respuestas del usuario
 */

#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdbool.h>
#include <stdlib.h>

/*Handlers de las señales*/
void sigalrm_handler(int sig);

/* Variable de los puntos de la ronda */
int total_puntos = 10;

int main(int argc, char **argv)
{
    /*Asignamos la señal de la alarma*/
    signal(SIGALRM, sigalrm_handler);

    int res = 0;
    int trueres = atoi(argv[0]);
    bool resultado_correcto = false;

    while(!resultado_correcto)
    {    
        /*Imprime las respuestas, por si se quieren comprobar*/
        //printf("(%d)", trueres);
        
        fflush(stdin);

        scanf("%d", &res);
        //printf("\n((%d))", res);
        if(res == trueres)
        {
            resultado_correcto = true;
            kill(getppid(), SIGUSR1);
        }else{
            kill(getppid(), SIGUSR2);
        }
    }
    sleep(10);
    return 0;
}
void sigalrm_handler(int sig)
{
    kill(getppid(), SIGALRM);
}
