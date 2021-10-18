#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{
    pid_t p1;
    int contador;

    /*Crea proceso*/
    p1 = fork();
    if(p1 == 0)
    {
        /*Hijo*/
        for(contador = 1; contador <= 100; contador++)
            printf("Hijo -> contador: %d\n",contador);
        
        sleep(1);
        exit(0);
    }
    else
    {
        /*Padre*/
        for(contador = 500; contador <= 600; contador++)
            printf("Padre -> contador: %d\n",contador);
        sleep(1);
        wait(NULL);
    }
    return 0;
}