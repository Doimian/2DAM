/*
 * Damian
 * PSP 1.2.7 (fork)
 * Manejar la comunicación entre dos procesos (padre e hijo) mediante un fichero externo
 * */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>

/*Handlers*/
void sigterm_handler(int sig);
void sigusr1_handler(int sig);
int main(void)
{
    /*Asociamos los handlers*/
    signal(SIGTERM, sigterm_handler);
    signal(SIGUSR1, sigusr1_handler);
     
    /*Separamos el proceso en padre e hijo*/
    pid_t pid = fork();
    if(pid)
    {
        /*Hijo*/
        execl("/bin/alacritty","", NULL);

    }else if(pid > 0)
    {
        /*Padre*/


    }else{
        /*Error*/
        printf("Error");
        return 0;
    }


    return 0;
}
void sigterm_handler(int sig)
{

}
void sigusr1_handler(int sig)
{

}
