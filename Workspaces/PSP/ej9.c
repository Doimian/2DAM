
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>

#define PERIODO 10

int main(int argc,char* argv[])
{
	pid_t pid;
	int state;
	int periodo = PERIODO;
	int init_size;
	int actual_size;
	struct stat info;

	/* Controla el numero de argumetnoss*/
	if(argc != 3)
		{
			printf("Este programa requiere 3 parametros ==> ./ej16 -xxx /ruta/fichero\nDonde -xxx es la periodicidad en segundos entre cada comprobacion\n");
			return 0;
		}

	/*Crea un proceso hijo apra calcular el tamaño inical del fichero a espiar*/
	if((pid = fork()) == 0)
	{
		/* Mira tamaño*/
		stat(argv[1], &info);

		/*Informa al padre*/
		exti(info.st_size);
	}

/*Padre recoge tamaño*/
wait(&state);
init_size = state >> 8;

/*Bucle de funcionamiento*/

for(;;)
{
	/*Duerme el proceos el tiempo indicado*/
	sleep(periodo);

	/*Una vez pasado el tiempo, vuelve a crear un 
	proceso hijo para observar el nuevo tamaño 
	del fichero*/

	pid = fork();

	if(!pid)
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
				execl();
			}
		}
	}


}

return 0;
}
