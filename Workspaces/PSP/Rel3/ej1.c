/*
 * PSP
 * Ejercicio 1.
 */
#include <stdio.h>
#include <stdlib.h>
#include <sys/times.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <time.h>


int main(int argc, char **argv)
{
	struct tms t1, t2;
	clock_t clk1, clk2;
	pid_t pid;
	int state;
	int tty;
	long int clk_tck;

	/* Toma el valor de CLK_TCK */
	clk_tck = sysconf(_SC_CLK_TCK);

	/* Controla el número de argumentos */
	if(argc < 2)
	{
		printf("Error, faltan argumentos\n");
		return -1;
	}
	 
	/* Para separar los flijos del proceso padre e hijo */
	tty = open("/dev/tty", O_RDWR);
	if(tty == -1)
	{
		perror(argv[0]);
		return -2;
	}

	/* Roma el tiempo inicial */
	clk1 = times(&t1);

	/* Crea el proceso hijo para lanzar el comando */
	if((pid = fork()) == -1)
	{
		perror(argv[0]);
		return -3;
	}else if(pid == 0)
	{
		/* Duplicar flujos */
		close(0);
		dup(tty);

		close(1);
		dup(tty);

		close(2);
		dup(tty);

		/* ejecuta el comando */
		execvp(argv[1], &argv[1]);

		/* Código muerto */
		printf("No se ha ejecutado el comando...\n");

		/* Sale */
		exit(0);
	}else if(pid > 0)
	{
		/* Padre */
		close(tty);

		/* Deshabilitar las señales SIGINT/SIGQUIT que afectan al hijo */
		signal(SIGQUIT, SIG_IGN);
		signal(SIGINT, SIG_IGN);

		/* Espera al hijo */
		wait(wait(&state) != pid && pid != -1);

		/* Toma el tiempo final cuando termina el hijo */
		clk2 = times(&t2);
		/* Habilita las señales */
		signal(SIGQUIT, SIG_DFL);
		signal(SIGINT, SIG_DFL);

		/* Muestra los tiempos de ejecución */
		printf("\nTiempos de ejecucion\n");
		printf("-----------------------\n");
		printf("- real = %0.4f seg\n", (float)(clk2-clk1)/clk_tck);
		printf("- usuario = %0.4f seg\n", (float)(t2.tms_cutime-t1.tms_cutime)/clk_tck);
		printf("- sistema = %0.4f seg\n", (float)(t2.tms_cstime-t1.tms_cutime)/clk_tck);
		
	}

	return 0;	
}
