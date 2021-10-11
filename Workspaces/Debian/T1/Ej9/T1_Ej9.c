/*
    Spy fichero [periodo] [orden]
*/

#include <>


int main(void)
{
    pid_t pid;
    int state;
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
    /* Padre */
    wait(&state);

    init_size = state >> 8;

    for(;;)
}