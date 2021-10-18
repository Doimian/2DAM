/*
    Spy fichero [periodo] [orden]
*/

#include <...>

#define PERIODO 5

int main(void)
{
    pid_t pid;
    int state;
    int periodo = PERIODO;
    int init_size;
    int actual_size;
    struct stat info;

    /* Controlar el numero de argumentos */

    /* Crea un proceso hijo para calcular el tamaño inicial del fichero a espiar */


    if((pid = fork()) == 0)
    {
        /* Mira tamaño */
        stat(argv[1], &info);

        /* Informa al padre */
        exit(info.st_size);
    }
    /* Padre recoge el tamaño*/
    wait(&state);

    /* Almavena el tamaño inicial para comparar*/
    init_size = state >> 8;


    for(;;)
    {
        /* Duerme el proceso el tiempo indicado*/
        sleep(periodo);

        /* Una vez pasado el tiempo, vuelve a crear un proceso hijo para observar el nuevo tamaño del fichero*/

        pid = fork()
        if(pid == 0)
        {
            /* Observa el tamaño del fichero */
            stat(argv[1], &info);

            /* Termina */
            exit(info.st_size);
        }
        else if(pid > 0)
        {
            /* Padre */
            wait(&state);

            /* Tamaño actual */
            actual_size = state >> 8;

            /* Comprueba si han ocurrido cambios */
            if(actual_size != init_size)
            {
                printf("El ficharo espiado ha sido modificado. Tamano actual : %d\n", actual_size);

                /* Actualiza las variables */
                init_size = actual_size;

                /* Crea un proceso hijo para ejecutar al comando indicado */
                if(fork() == 0)
                    execl(...);
            }

        }
    }
    return 0;
}