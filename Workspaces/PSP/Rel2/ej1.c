/* Damian
 * PSP 1.2.1
 * Señal Padre -> Hijo
 */

#include <stdio.h>
#include <unistd.h>
#include <signal.h>

int main(void)
{
    /*Creamos un hijo*/
    pid_t pid = fork();
    if(pid==0)
    {
        /*HIJO*/
        while(1)
        {
            sleep(1);
            printf("Hola! Estoy vivo!\n");
        }

    }else if(pid > 0)
    {
        /*PADRE*/
        sleep(10);
        kill(pid, SIGTERM);

    }else
    {
        /*Error*/
        printf("Soy el error");
    }

    return 0;
}
