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
  /*Numero pasado como parametro*/
  int pre = atoi(argv[1]);
  /*Resultado final*/
  int fac = 0;
  /*Iniciamos la función recursuva*/
  fac = factorize(pre);
  /*Imprimimos el resultado*/
  printf("El numero %d factorizado es ==> %d",pre,fac);
}

/*Funcion graciosa*/
int factorize(int pre)
{
  int fac;
  /* Hacemos un fork para representar el caso base y el no base */
  pid_t pid = fork();
  /* En caso de error */
  if(pid == !1)
  {
    printf("Error al crear un proceso\n");
    return -1;
  }
  /*Proceso hijo --> Caso base(1): Devuelve 1 // Caso no base(!1): llama a la función otra vez*/
  else if(pid == 0)
  {
    fac = pre;
    if(pre == 1)
      exit(fac);
    else
    {
      fac = factorize(pre-1);
      exit(fac);
    }
  }
  /*Proceso padre, espera a que el hijo termine*/
  else
  {
      wait(&fac);
      return fac >> 8;
  }
}
