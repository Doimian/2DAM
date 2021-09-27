/*
    Ejemplo fork()
*/

#include <stdio.h>
#include <unistd.h>

int main(void)
{
    /* Tipo de retorno de fork()*/
    pid_t ok;
    int contador = 10;
    int valor = 121;

    /* Crea un proceso hijo*/
    ok = fork();

    /* Quien es quien? */
    if( ok == -1)
    {
        printf(" No se puede crear proceso\n");
        return -1;
    }

    if(ok > 0)
    {
        /* Proceso padre */
        printf("Hola, soy el proceso padre de PID : %d\n", getpid());
        contador++;
        valor--;
        printf("Padre -> contador : %d, valor : %d\n", contador, valor);
    }

    else if(ok == 0)
    {
        /* Proceso hijo */
        printf("Hola, soy el proceso hijo de PID : %d\n"), getpid());
        contador--;
        valor++;
        printf("Hijo -> contador : %d, valor : %d\n", contador, valor);
    }

}