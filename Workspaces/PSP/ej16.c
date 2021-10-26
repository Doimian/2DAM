#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>

int factorize(int);

int main(int argc, char* argv[])
{
  /*Comprobar que se le ha pasado el numero como parametro*/
  if(argc != 2)
  {
    printf("Este programa requiere como parametro un numero para factorizar ==> ./ej16 1111 \n(además este número debe ser menor que 6 para que el programa funcione correctamente)\n");
    return 0;
  }
  int pre = atoi(argv[1]);
  int fac;
  /* Primer fork */
  pid_t pid = fork();
  /*Origen de la rama de hijos que buscarán el factor*/
  if(pid==0)
  {
   int num = factorize(pre);
   exit(num);
  }
  else if(pid > 0)
  {
    /*Proceso padre original que espera el resultado*/
    wait(&fac);
    fac >> 8;
    printf("El factorial de %d es %d\n", pre, fac);
    return 0;
  }
}

int factorize(int pre)
{
  int num;
    pid_t pid = fork();
    if(pid == 0)
    {
      /*Hijo*/
      if(pre <= 1)
      {
        exit(1);
      }
      else
      {
        exit(pre * factorize(pre-1));
      }
    }
    else if (pid > 0)
    {
      /*Padre*/
      wait(&num);
      return num >> 8;
    }
    else
    {
      printf("Error al crear un proceso\n");
    }
}
