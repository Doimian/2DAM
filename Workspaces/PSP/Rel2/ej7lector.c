/*
 * Damian
 * PSP 1.2.7 (lector)
 * Manejar la comunicación entre dos procesos mediante un fichero externo
 * */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

#define TAM 80

/* Manejador de señal SIGUSR1 */
void signal_handler(int sig);

pid_t pid_escritor;

int main(int argc, char **argv)
{
		signal(SIGUSR1, signal_handler);
		signal(SIGTERM, signal_handler);
	
    if(argc != 2)
    {
        printf("Este proceso requiere como argumento el PID del proceso escritor asociado\n");
        exit(0);
    }
		pid_escritor = atoi(argv[1]);
		printf("Proceso lector de PID : %d\n", getpid());

		/*Ciclo señales*/
		while(1)
				pause();
		return 0;
}
void signal_handler(int sig)
{
		/*Tratamiento de SIGUSR1*/
		if(sig == SIGUSR1)
		{
        /*Lee el fichero*/
        FILE *fd;
        char msg[TAM];

        /*Abre fichero en modo lectura*/
        fd = fopen("buzon", "rt");
        fgets(msg, TAM -1, fd);
        fclose(fd);

        /*Muestra mensaje*/
        printf("Recibido : %s", msg);

        /*Informa al escritor de que he leido */
        kill(pid_escritor, SIGUSR1);
		}else if(sig == SIGTERM)
		{
				/*Tratamiento de SIGTERM*/
				printf("Lector termina...\n");
				exit(0);
		}
}
