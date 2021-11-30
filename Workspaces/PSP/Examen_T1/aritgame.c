/*
 * Examen Tema 1
 * aritgame
 * Proceso que maneja las operaciones matemáticas
 */

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#include <math.h>
#include <signal.h>
#include <sys/wait.h>
#include <stdbool.h>

#define NUM_OPERACIONES 6

/*Handlers*/
void sigusr1_handler(int sig);
void sigusr2_handler(int sig);
void sigalrm_handler(int sig);

/*PIDs de los otros procesos*/
pid_t pid_temp;
pid_t pid_comp;

/*Puntuaciones*/
int puntuacion = 0;
int puntuacion_ronda = 0;


/*Operacion completada*/
bool operacion_completada = false;

int main(void)
{
    /* Asignamos las señales*/
    signal(SIGUSR1, sigusr1_handler);
    signal(SIGALRM, sigalrm_handler);
    signal(SIGUSR2, sigusr2_handler);

    int pri_op = 0;
    int seg_op = 0;
    int res = 0;
    char respuesta[3];
    char signo_op = ' ';

    /*Semilla aleatoria*/
    srand(time(NULL));
     
    /* Guardamos el pid del proceso como string para poder enviarlo después*/

    /* Introduce el juego */
    printf(" ------------------------ \n");
    printf("|        AritGame        |\n");
    printf("| Responde %d preguntas:  |\n", NUM_OPERACIONES);
    printf(" ------------------------ \n");

    /*Bucle de operaciones*/
    int i;
    for(i = 0; i < NUM_OPERACIONES; i++)
    {
        /* Creamos la operación*/
        pri_op = (rand()%21 - 11);
        seg_op = (rand()%21 - 11);
        signo_op = (rand()%4);

        /*Reiniciamos el valor de la puntiacion por ronda*/
        puntuacion_ronda = 10;

        /* Nos aseguramos que el segundo numero no sea 0 en una división*/
        if(seg_op == 0 && signo_op == 3)
        {
            seg_op++;
        }

        switch(signo_op)
        {
            case 0: signo_op = '+'; 
                    res = pri_op + seg_op;
                    break;

            case 1: signo_op = '-'; 
                    res = pri_op - seg_op;
                    break;

            case 2: signo_op = 'x';
                    res = pri_op * seg_op;
                    break;

            case 3: signo_op = '/'; 
                    res = pri_op / seg_op;
                    break;
        }
        /*Guardamos la respuesta como string*/
        sprintf(respuesta, "%d",res);

        /* Creamos el proceso checker */
        pid_comp = fork();
        if(pid_comp == 0)
        {
            /*Hijo*/
            execl("./checker", respuesta, (char *)0);
        }else
        {
            /* Creamos el proceso que maneja el tiempo de la operación*/
            pid_temp = fork();

            if(pid_temp == 0)
            {
                /*Hijo*/
                execl("./timecontroller",  &signo_op, &pid_comp, (char *)0);
                
            }else
            {
                /*Proceso principal*/
                /* Mostramos la operación*/ 
                if(signo_op == '-' && seg_op < 0)
                    printf("\n%d. -> %d %c (%d) = \n", i+1, pri_op, signo_op, seg_op);
                else
                    printf("\n%d. -> %d %c %d = \n", i+1, pri_op, signo_op, seg_op);

                /*Esperamos una señal del proceso checker (correcto / incorrecto / tiempo fuera) */
                operacion_completada = false;
                while(!operacion_completada)
                {
                    operacion_completada = true;
                    pause();
                }
                printf("Esta ronda te llevas %d puntos", puntuacion_ronda);
            }
        }
    }
    /* Terminamos con los procesos residuales*/ 
    kill(SIGKILL, pid_comp);
    kill(SIGKILL, pid_temp);

    /*Ponemos el resultado*/
    printf(" \n------------------------ \n");
    printf("|        AritGame        |\n");
    printf("| Puntuación Final: %d   |\n", puntuacion);
    printf(" ------------------------ \n");
    return 0;
}
void sigusr1_handler(int sig)
{
    puntuacion += puntuacion_ronda;
    /*Respuesta correcta*/
    printf("\t[Correcta]\n");
    /*Terminamos los otros dos procesos*/
    kill(SIGKILL, pid_comp);
    kill(SIGKILL, pid_temp);
}
void sigusr2_handler(int sig)
{
    printf("\t[Incorrecta] puedes intentarlo de nuevo...\n");
    operacion_completada = false;
    puntuacion_ronda--;
}
void sigalrm_handler(int sig)
{
    /*Tiempo fuera*/
    puntuacion_ronda = 0;
    printf("TIME OUT\n");
    kill(SIGKILL, pid_comp);
    kill(SIGKILL, pid_temp);
}
