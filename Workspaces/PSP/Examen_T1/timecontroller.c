/*
 * Examen Tema 1
 * timecontroller
 * Proceso que maneja los tiempos de las operaciones
 */

#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define TIME_SUMA 5
#define TIME_RESTA 6
#define TIME_MULTI 7
#define TIME_DIVI 8

/*Handler para la alarma*/
void handler_sigalarm(int sig);

pid_t *pid_comp;

int main(int argc, char **argv)
{
    /*Asignamos el handler de la alarma*/
    signal(SIGALRM,handler_sigalarm);

    /*Guardamos el PID del proceso checker*/
    pid_comp = (pid_t *)argv[1];
    switch((int)*argv[0])
    {
        case '+':
                alarm(TIME_SUMA);
                break;

        case '-': 
                alarm(TIME_RESTA);
                break;

        case 'x':
                alarm(TIME_MULTI);
                break;

        case '/':
                alarm(TIME_DIVI);
                break;
    }
    sleep(10);
    return 0;
}
void handler_sigalarm(int sig)
{
    kill(*pid_comp, SIGALRM);
}
