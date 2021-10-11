/*

	PSP

	Tema 1. Procesos

	Ejercicio 1.6

*/



#include <stdio.h>

#include <stdlib.h>

#include <sys/wait.h>

#include <unistd.h>



#define NUM_PROCESOS 10

#define NUM_MSG 20



/* Variable global*/

int global = 0;



/*Prototipos*/

void codigo_proceso(int lid);



int main(void)

{

	int i;

	int codigo_salida;

	pid_t pid;

	int id[NUM_PROCESOS];



	/* Crea array con identificadores locales propios*/

	for(i = 0; i < NUM_PROCESOS; i++)

		id[i] = i + 100;

	/* Crear un numer de procesos indicados en NUM_PROCESOS*/

	for(i = 0; i < NUM_PROCESOS; i++)

	{

		/* Crea el proceso de turno*/

		pid = fork();

		if(pid == -1)

		{

			printf("Error al crear el proceso %d", i);

			return -1;

		}else if(pid == 0)

		{

			/* Proceso hijo*/

			codigo_proceso(id[i]);

		}

	}



	/*El proceso padre espera la finalizacion de todos los hijos*/

	for(i = 0; i < NUM_PROCESOS; i++)

	{

		/* Espera la terminacion de un hijo cualquiera*/

		wait(&codigo_salida);



		/* El padre informa de la finalizacion de un de sus hijos*/

		printf("[Padre] -> Proceso hijo con id local %d ha terminado\n", codigo_salida >> 8);

	}

	return 0;

}



/* Funcion para todos los procesos hijos */

void codigo_proceso(int lid)

{

	/* Variable local al proceso */

	int i;



	/* Imprime 10 veces el mensaje identificativo con valores de variable */

	for(i = 0; i < NUM_MSG; i++ )

		printf("[Proceso hijo] -> PID: %d, local id :  %d, local : %d, global : %d\n", getpid(), lid, i, ++global);



	/* Proceso termina correctamente*/

	exit(lid);

}

