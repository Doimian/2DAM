#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>

#define PERIODO 10
int main(int argc,char* argv[])
{
	pid_t pid;
	int state;
	int periodo = PERIODO;
	int init_size;
	int actual_size;
	char* orden;
	struct stat info;

	/* Controla el numero de argumetnoss*/
	if(argc != 4)
	{
			printf("Este programa requiere 3 parametros ==> ./ej9 /ruta/fichero -p orden\nDonde -p es la periodicidad entre cada comprobacion y orden un comando a ejecutar\n");
			return 0;
	}
	/*Asignamos los valores*/
	periodo = atoi(argv[2]);
	orden = argv[3];

	/*Crea un proceso hijo apra calcular el tamaño inical del fichero a espiar*/
	if((pid = fork()) == 0)
	{
		/* Mira tamaño*/
		stat(argv[1], &info);

		/*Informa al padre*/
		exit(info.st_size);
	}

	/*Padre recoge tamaño*/
	wait(&state);
	init_size = state >> 8;

/*Bucle infinito de comprobación*/
while(1)
{
	/*El proceso espera el tiempo indicado*/
	sleep(periodo);

	/*Una vez pasado el tiempo, vuelve a crear un 
	proceso hijo para observar el nuevo tamaño 
	del fichero*/

	pid = fork();

	if(pid == 0)
	{
		/* Observa el tamaño del fichero*/
		stat(argv[1], &info);

		/*Termina*/
		exit(info.st_size);
	}
	else if(pid > 0)
	{
		wait(&state);

		/* Tamaño actual */
		actual_size = state >> 8;

		/* Comprueba si han ocurrido cambios*/
		if(actual_size != init_size)
		{
			printf("El fichero espiado ha sido modificado. Tamano actual: %d\n", actual_size);

			/*Actualiza */
			init_size = actual_size;

			/* Crea un proceso hijo para ejecutar al comando indicado*/
			if(!fork())
			{
				system(orden);
				exit(1);
			}
		}
	}
}
return 0;
}
