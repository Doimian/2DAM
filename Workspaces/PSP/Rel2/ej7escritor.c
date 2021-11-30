/*
 * Damian
 * PSP 1.2.7 (escritor)
 * Manejar la comunicación entre dos procesos mediante un fichero externo
 * */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#define TAM 80

pid_t pid_lector;

/* Manejador de señal SIGUSR1 */
void sigusr1_handler(int sig);
void sigterm_handler(int sig);

int main(int argc, char **argv)
{
		/*Asigna el manejador de señales */
		signal(SIGUSR1, sigusr1_handler);
		signal(SIGTERM, sigterm_handler);
		//kill();

		printf("Proceso escritor de PID : %d\n", getpid());
		printf("PID Lector : ");
		scanf("%d",&pid_lector);

		/*Autollamada */
		sigusr1_handler(SIGUSR1);

		/*Ciclo de funcionamiento*/
		/*Espera señal*/
		while(1)
				pause();
		return 0;
}
/* Se llamará cuando reciba SIGUSR1 desde el lector*/
void sigusr1_handler(int sig)
{
		FILE *fd;
		char msg[TAM];

		/* Pide mensaje, escribe e informa al lector*/
		/*Ciclo lectura y envio de mensajes*/
		printf("mensaje : \n");
		fgets(msg, TAM - 1, stdin);

		/*Escribe msg en fichero*/
		fd = fopen("buzon", "wt");
		fputs(msg, fd);
		fclose(fd);

		/*informa al lector*/
		kill(pid_lector, SIGUSR1);
}
void sigterm_handler(int sig)
{
		/*Pide al lector que vaya terminando*/
		kill(pid_lector, SIGTERM);

		/*Termina*/
		exit(0);
}
