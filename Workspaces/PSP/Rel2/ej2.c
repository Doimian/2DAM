
/* Damian
 * PSP 1.2.1
 * Señal Padre -> Hijo
 */

#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

int main(void)
{
    /*Creamos un hijo*/
    pid_t pid = fork();
    if(pid==0)
    {
        /*HIJO*/
        sleep(10);
        /*Se puede hacer un raise mediante el comando kill si primero le indicamos a qué proceso hacerselo*/
        kill(getpid(), raise(SIGTERM));

        /*También se podría hacer al contrario, un kill mediante el comando raise */
        /*raise(kill(getpid(), SIGTERM));*/
        printf("Hola! Estoy vivo!\n");
    }else if(pid > 0)
    {
        /*PADRE*/
        int i;
        for(i = 0;i<10;i++)
        {
            sleep(1); 
            printf("Me pregunto como estara mi hijo\n");
        }
        wait(NULL);
        printf("Mi hijo ha muerto!\n");
    }else
    {
        /*Error*/
        printf("Soy el error");
    }

    return 0;
}
